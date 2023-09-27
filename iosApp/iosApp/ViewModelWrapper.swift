//
//  ViewModelWrapper.swift
//  iosApp
//
//  Created by Thomas Salvetat on 25/09/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Combine
import SwiftUI
import shared

public class ViewModelWrapper<V, S, E>: ObservableObject where V: BaseViewModel<S,E>, S: AnyObject, E: AnyObject {
    public var wrapped: V
    @Published
    public var state: S
    public var sideEffect: AnyPublisher<E, Never>

    public init(_ wrapped: V) {
        self.wrapped = wrapped
        self.state = wrapped.container.stateFlow.value as! S
        self.sideEffect = wrapped.container.sideEffectFlow.asPublisher() as AnyPublisher<E, Never>
        (wrapped.container.stateFlow.asPublisher() as AnyPublisher<S, Never>)
            .receive(on: RunLoop.main)
            .assign(to: &$state)
    }

    deinit {
        self.wrapped.onCleared()
    }
}
