//
//  PlayerDriverIos.swift
//  iosApp
//
//  Created by Thomas Salvetat on 29/09/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

class PlayerDriverIos: PlayerDriver {

    func __start() async throws {
        try await Task.sleep(until: .now + .seconds(10), clock: .suspending)
    }

}

