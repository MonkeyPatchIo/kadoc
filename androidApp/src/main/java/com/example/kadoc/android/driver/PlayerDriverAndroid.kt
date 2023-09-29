package com.example.kadoc.android.driver

import com.example.kadoc.PlayerDriver
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

class PlayerDriverAndroid : PlayerDriver {
    override suspend fun start() {
        delay(10.seconds)
    }
}