package com.example.kadoc

import io.monkeypatch.mobk.api.observable
import io.monkeypatch.mobk.viewmodel.MobkViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.time.Duration.Companion.seconds

class PlayerStore(private val driver: PlayerDriver) : MobkViewModel() {
    var running by observable(false)

    private var activeJob: Job? = null

     fun start() = viewModelScope.launch(Dispatchers.Main) {
         activeJob?.cancelAndJoin()
            activeJob = viewModelScope.launch {
                try {
                    running = true
                    withContext(Dispatchers.Default) {
                        driver.start()
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

    fun cancel() {
        println("Cancel")
        activeJob?.cancel()
    }

}


interface PlayerDriver {
    suspend fun start()
}