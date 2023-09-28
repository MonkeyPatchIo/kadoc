package com.example.kadoc

import org.koin.dsl.module

actual fun getPlatformModule() = module {
    factory { CounterStore() }
    factory { TipStore(get()) }
    factory { CryptoStore(get())}
}