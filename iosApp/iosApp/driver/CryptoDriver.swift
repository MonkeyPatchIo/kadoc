//
//  CryptoDriver.swift
//  iosApp
//
//  Created by Thomas Salvetat on 28/09/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
import CryptoKit

class CryptoDriverIos : CryptoDriver {
    func hash(data: String) -> String {
        let value = data.data(using: .utf8)!
        let digest = SHA512.hash(data: value)

        // Convert the digest bytes to a hexadecimal string
        let hexString = digest.map { String(format: "%02hhx", $0) }.joined()
        return hexString
    }
}
