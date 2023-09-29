package com.example.kadoc

import io.monkeypatch.mobk.api.observable
import io.monkeypatch.mobk.viewmodel.MobkViewModel
import kotlinx.coroutines.launch

class TipStore(repository: TipOfDayRepository) : MobkViewModel() {
    var tipOfDay by observable<String?>(null)

    override fun onCleared() {
        super.onCleared()
        println("TipStore cleared")
    }

    init {
        println("init tipStore")
        viewModelScope.launch {
            repository.getTipOfDay().let {
                tipOfDay = it.fact
            }
        }
    }
}