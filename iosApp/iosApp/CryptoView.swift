//
//  CryptoView.swift
//  iosApp
//
//  Created by Thomas Salvetat on 28/09/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CryptoView: View {
    private var store = Resolver().cryptoStore()

    @State private var text: String = ""

    var body: some View {
        Observer {
            VStack(spacing: 10) {
                TextEditor(text: $text)
                    .frame(maxHeight: 250)
                Divider()
                Text(store.data)
                Divider()
                Text(store.hashed)
                Spacer()
            }
        }
        .onChange(of: self.text, perform: { value in
            store.data = value
        })
    }
    
}

struct CryptoView_Previews: PreviewProvider {
    static var previews: some View {
        CryptoView()
    }
}
