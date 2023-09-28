package com.example.kadoc.android

import com.example.kadoc.CryptoDriver
import com.example.kadoc.android.driver.CryptoDriverAndroid
import com.example.kadoc.sharedModules
import org.koin.dsl.bind
import org.koin.dsl.module

private val appModule = module {
    single { CryptoDriverAndroid() } bind CryptoDriver::class
}

val appModules = appModule + sharedModules