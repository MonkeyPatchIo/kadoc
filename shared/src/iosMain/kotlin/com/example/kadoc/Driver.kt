package com.example.kadoc

import org.koin.core.KoinApplication
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.module.Module
import org.koin.dsl.module


object Driver : KoinComponent {
    fun register(application: KoinApplication, callback: Module.() -> Unit) {
        application.apply {
            val appModule = module {
                callback(this)
            }
            modules(appModule)
        }
    }

    fun registerCryptoDriver(module: Module, cryptoDriver: CryptoDriver) {
        module.single {
            cryptoDriver
        }
    }
}