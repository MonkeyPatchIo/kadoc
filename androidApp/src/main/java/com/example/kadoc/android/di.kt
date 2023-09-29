package com.example.kadoc.android

import com.example.kadoc.CryptoDriver
import com.example.kadoc.PlayerDriver
import com.example.kadoc.android.driver.CryptoDriverAndroid
import com.example.kadoc.android.driver.PlayerDriverAndroid
import com.example.kadoc.sharedModules
import org.koin.dsl.bind
import org.koin.dsl.module

private val appModule = module {
    single { CryptoDriverAndroid() } bind CryptoDriver::class
    single { PlayerDriverAndroid() } bind PlayerDriver::class
}

val appModules = appModule + sharedModules