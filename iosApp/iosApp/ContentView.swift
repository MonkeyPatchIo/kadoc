import SwiftUI


public enum NavigationItem: Hashable {
    case counter, tip, crypto, roll, transaction,player
}

class Coordinator: ObservableObject {
    @Published var path = [NavigationItem]()

   func gotoHomePage() {
       path.removeLast(path.count)
   }

    func push(_ item: NavigationItem) {
        path.append(item)
    }
}

struct ContentView: View {
    @State var path: [NavigationItem] = []
    
    var body: some View {
        NavigationStack(path: $path) {
            HomeView()
                .navigationDestination(for: NavigationItem.self) { item in
                    switch item {
                    case .counter:
                        CounterView()
                    case .tip:
                        TipView()
                    case .crypto:
                        CryptoView()
                    case .roll:
                        RollView()
                    case .transaction:
                        TransactionView()
                    case .player:
                        PlayerView()
                    }
                }
        }
    }
}


struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
