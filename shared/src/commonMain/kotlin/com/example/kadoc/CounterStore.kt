package com.example.kadoc

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce


data class CounterState(
    val counter: Int = 0
)

sealed class CounterStateSideEffect {
    data class Warning(val text: String) : CounterStateSideEffect()
}

class CounterStore: BaseViewModel<CounterState, CounterStateSideEffect>() {

    override val container = viewModelScope.container<CounterState, CounterStateSideEffect>(CounterState())

    fun increment() = intent {
        reduce {
            state.copy(counter = state.counter + 1)
        }
    }
}