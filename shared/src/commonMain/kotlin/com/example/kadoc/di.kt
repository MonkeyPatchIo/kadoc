package com.example.kadoc

import io.ktor.client.HttpClient
import org.koin.dsl.module

val sharedModules = module {
    single { HttpClient() }
    single {TipOfDayRepository(get())}
    single { CryptoManager(get()) }
} + getPlatformModule()