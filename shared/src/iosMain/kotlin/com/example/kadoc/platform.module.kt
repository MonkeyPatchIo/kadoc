package com.example.kadoc

import org.koin.dsl.module

actual fun getPlatformModule() = module {
    single { CounterStore(get()) }
}