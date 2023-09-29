import SwiftUI

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
            CounterView {
                path.append(.tip)
            }
            .navigationDestination(for: NavigationItem.self) { item in
                switch item {
                case .tip:
                    TipView()
                }
            }
        }
	}
}

enum NavigationItem: Hashable {
    case  tip
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
