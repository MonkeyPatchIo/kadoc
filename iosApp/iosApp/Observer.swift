//
//  Observer.swift
//

import SwiftUI
import shared

struct ObserverView<V: View> : View {
    @ObservedObject var reactionObservable: ReactionObservable<V>

    var body: some View {
        self.reactionObservable.view
    }
}

func Observer<V: View>(@ViewBuilder f: @escaping  () -> V) -> some View {
    let reactionObservable = ReactionObservable(f: f)
    return ObserverView(reactionObservable: reactionObservable)
}

class ReactionObservable<V>: ObservableObject {
    @Published var view: V? = nil
    var disposer: ReactionDisposer? = nil

    init(f: @escaping () -> V) {
        disposer = ApiKt.autorun { [weak self] in
            self?.view = f()
        }
    }

    deinit {
        let d = disposer
        disposer = nil
        DispatchQueue.main.async {
            d?.invoke()
        }
    }

}

@propertyWrapper class VM<S>: ObservableObject where S: Mobk_viewmodelMobkViewModel {
     var wrappedValue: S

    public init(wrappedValue:@escaping @autoclosure () -> S) {
        self.wrappedValue =  wrappedValue()
    }

    deinit {
        self.wrappedValue.onCleared()
    }
}

extension Mobk_viewmodelMobkViewModel {
    func asStateObject<S>() -> StateObject<VM<S>> where S: Mobk_viewmodelMobkViewModel {
        return StateObject(wrappedValue: VM(wrappedValue: self as! S))
    }
}

func asStateObject<S>(_ factory: @autoclosure @escaping () -> S) -> StateObject<VM<S>>  where S: Mobk_viewmodelMobkViewModel {
    return factory().asStateObject()
}
