package com.example.kadoc

import org.koin.core.component.KoinComponent
import org.koin.core.component.get


object Resolver : KoinComponent {

    fun counterStore(): CounterStore {
        return get()
    }
}