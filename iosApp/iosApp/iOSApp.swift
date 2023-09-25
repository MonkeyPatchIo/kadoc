import SwiftUI
import shared

@main
struct iOSApp: App {

    init() {
        Injector().doInitKoin { modules in

        }
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
