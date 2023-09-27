//
//  asPublisher.swift
//  iosApp
//
//  Created by Thomas Salvetat on 27/09/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import shared
import Combine

public extension Kotlinx_coroutines_coreFlow {
    func asPublisher<T: AnyObject>() -> AnyPublisher<T, Never> {
        (FlowPublisher(flow: self) as FlowPublisher<T>).eraseToAnyPublisher()
    }

    func asPublisher<T: AnyObject>(type: T.Type) -> AnyPublisher<T, Never> {
        (FlowPublisher(flow: self) as FlowPublisher<T>).eraseToAnyPublisher()
    }
}
