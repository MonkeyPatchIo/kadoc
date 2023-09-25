package com.example.kadoc

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

actual fun getPlatformModule() = module {
    viewModel { CounterStore(get()) }
}