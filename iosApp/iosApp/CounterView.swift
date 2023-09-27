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
   @StateObject var counterStore = ViewModelWrapper<CounterStore, CounterState, CounterStateSideEffect>(Resolver().counterStore())

    var body: some View {
            VStack(spacing: 15) {
                Text(verbatim: String(self.counterStore.state.counter))

                       HStack {
                           Button(action: {
                               self.counterStore.wrapped.increment()
                           }) {
                               Text("Increment")
                           }
                       }
                   }
                   .padding()
    }
}

struct CounterView_Previews: PreviewProvider {
    static var previews: some View {
        CounterView()
    }
}
