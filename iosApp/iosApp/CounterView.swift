//
//  CounterView.swift
//  iosApp
//
//  Created by Thomas Salvetat on 25/09/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CounterView: View {
    @StateObject    @VM var counterStore: CounterStore = Resolver().counterStore()

    var body: some View {
        Observer {
            VStack(spacing: 15) {
                Text(verbatim: String(self.counterStore.counter))
                
                HStack {
                    Button(action: {
                        self.counterStore.decrement()
                    }) {
                        Text("Decrement")
                    }.disabled(!self.counterStore.decrementAvailable)
                    
                    Button(action: {
                        self.counterStore.increment()
                    }) {
                        Text("Increment")
                    }
                }
                
                if let message = self.counterStore.message {
                    Text(message)
                }
            }
        }
    }
}

struct CounterView_Previews: PreviewProvider {
    static var previews: some View {
        CounterView()
    }
}
