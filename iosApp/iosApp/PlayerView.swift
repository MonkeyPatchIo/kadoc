//
//  PlayerView.swift
//  iosApp
//
//  Created by Thomas Salvetat on 29/09/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct PlayerView: View {
    @StateObject @VM var store = Resolver().playerStore()

    var body: some View {
        Observer {
            VStack {
                Button(action: {
                    store.start()
                }) {
                    Text("Play")
                }
                Button(action: {store.cancel()}) {
                    Text("Cancel")
                }

                if store.running {
                    ProgressView()
                }
            }
        }
    }
}

struct PlayerView_Previews: PreviewProvider {
    static var previews: some View {
        PlayerView()
    }
}
