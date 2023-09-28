//
//  MobKViewModel.swift
//  iosApp
//
//  Created by Thomas Salvetat on 29/09/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

@propertyWrapper class VM<S>: ObservableObject where S: Mobk_viewmodelMobkViewModel {
     var wrappedValue: S

    public init(wrappedValue:@escaping @autoclosure () -> S) {
        debugPrint("init VM \(S.self)")
        self.wrappedValue =  wrappedValue()
    }

    deinit {
        debugPrint("deinit VM \(S.self)")
        self.wrappedValue.onCleared()
    }
}

func asStateObject<S>(_ factory: @autoclosure @escaping () -> S) -> StateObject<VM<S>>  where S: Mobk_viewmodelMobkViewModel {
    return StateObject(wrappedValue: VM(wrappedValue: factory()))
}
