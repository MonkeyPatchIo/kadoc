package com.example.kadoc

import io.monkeypatch.mobk.api.observable
import io.monkeypatch.mobk.viewmodel.MobkViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.time.Duration.Companion.seconds

class TransactionStore : MobkViewModel() {
    var running by observable(false)

    suspend fun start() = withContext(Dispatchers.Main) {
        try {
            running = true
            withContext(Dispatchers.Default) {
                delay(10.seconds)
            }
        } catch (e: CancellationException) {
            println("Cancelled")
            running = false
        } finally {
            println("Finally")
            running = false
        }

    }
}