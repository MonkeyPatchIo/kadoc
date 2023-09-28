import SwiftUI
import shared

@main
struct iOSApp: App {

    init() {
        Injector().doInitKoin { declaration in
            Driver().register(application: declaration) { module in
                Driver().registerCryptoDriver(module: module, cryptoDriver: CryptoDriverIos())
            }
        }
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
