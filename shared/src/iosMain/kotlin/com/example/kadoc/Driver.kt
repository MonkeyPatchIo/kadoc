package com.example.kadoc

import org.koin.core.module.Module
import org.koin.dsl.module


object Driver {

    fun registerCryptoDriver(cryptoDriver: () -> CryptoDriver): Module = module {
        single {
            cryptoDriver()
        }
    }

}