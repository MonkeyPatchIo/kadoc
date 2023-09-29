//
//  HomeView.swift
//  iosApp
//
//  Created by Thomas Salvetat on 29/09/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct HomeView: View {
    var body: some View {
        List {
            NavigationLink("MobK Counter", value: NavigationItem.counter)
            NavigationLink("MobK Tip", value: NavigationItem.tip)
            NavigationLink("Crypto use case", value: NavigationItem.crypto)
            NavigationLink("Roll", value: NavigationItem.roll)
        }
    }
}

struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeView()
    }
}
