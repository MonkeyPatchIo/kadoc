//
//  TransactionView.swift
//  iosApp
//
//  Created by Thomas Salvetat on 29/09/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct TransactionView: View {
    @StateObject @VM var store = Resolver().transactionStore()

    @State var task: Task<Void, Error>? = nil

    var body: some View {
        Observer {
            VStack {
                Button(action: {
                    self.task = Task.detached {
                        // Without SKIE, we can't call KMP suspend function from another thread than main thread
                        try await store.start()
                     }
                }) {
                    Text("Start")
                }
                Button(action: {self.task?.cancel()}) {
                    Text("Cancel")
                }

                if store.running {
                    ProgressView()
                }
            }
        }
    }
}

struct TransactionView_Previews: PreviewProvider {
    static var previews: some View {
        TransactionView()
    }
}
