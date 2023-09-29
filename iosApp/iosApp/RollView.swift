//
//  RollView.swift
//  iosApp
//
//  Created by Thomas Salvetat on 29/09/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct RollView: View {
    @StateObject @VM var store: RollStore = Resolver().rollStore()

    var body: some View {
        Observer {
            VStack(spacing: 15) {
                Text(store.dice.representation)
                Text(self.diceValue(dice: store.dice))

                Button(action: { store.roll() }) {
                    Text("Reroll")
                }
            }
        }
    }

    private func diceValue(dice: Dice) -> String {
        switch dice {
        case .one:
           return "1"
       case .two :
           return "2"
       case .three:
           return "3"
       case .four:
           return "4"
       case .five:
           return "5"
        }
    }
}

struct RollView_Previews: PreviewProvider {
    static var previews: some View {
        RollView()
    }
}
