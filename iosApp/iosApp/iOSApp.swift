import SwiftUI
import shared

@main
struct iOSApp: App {

    init() {
        Injector().doInitKoin(modules: [
            Driver().registerCryptoDriver {
                CryptoDriverIos()
            },
            Driver().registerPlayerDriver {
                PlayerDriverIos()
            }
        ])
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
