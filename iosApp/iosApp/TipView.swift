//
//  TipView.swift
//  iosApp
//
//  Created by Thomas Salvetat on 29/09/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared


struct TipView: View {
@StateObject @VM private var tipStore = Resolver().tipStore()

    var body: some View {
        Observer {
            if let tip = tipStore.tipOfDay {
                Text(tip)
                    .padding()
            }
        }
    }
}

struct TipView_Previews: PreviewProvider {
    static var previews: some View {
        TipView()
    }
}
