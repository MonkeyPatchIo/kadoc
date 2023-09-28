package com.example.kadoc

import org.koin.core.component.KoinComponent
import org.koin.core.component.get


object Resolver : KoinComponent {
    fun tipStore(): TipStore = get()
    fun counterStore(): CounterStore = get()
    fun cryptoStore(): CryptoStore = get()
}