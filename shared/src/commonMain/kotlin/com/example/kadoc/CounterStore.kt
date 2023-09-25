package com.example.kadoc

import io.monkeypatch.mobk.api.computed
import io.monkeypatch.mobk.api.observable
import io.monkeypatch.mobk.api.whenReaction
import io.monkeypatch.mobk.viewmodel.MobkViewModel
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds


class CounterStore(repository: TipOfDayRepository) : MobkViewModel() {
    var counter by observable(0)
    var message by observable<String?>(null)
    var tipOfDay by observable<String?>(null)

    val decrementAvailable by computed {
        counter > 0
    }

    val counterWatch = reaction(
        delay = 5.seconds,
        trackingFn = { counter }) { counter ->
        if (counter != null && counter > 10) {
            message = "Counter is too high"
        }
    }

    val warningWatch = whenReaction(predicate = { counter > 12 }) {
        message = "Counter is really too high"
    }

    fun increment() {
        counter++
    }

    fun decrement() {
        counter--
    }

    init {
        viewModelScope.launch {
            repository.getTipOfDay().let {
                tipOfDay = it.fact
            }
        }
    }
}