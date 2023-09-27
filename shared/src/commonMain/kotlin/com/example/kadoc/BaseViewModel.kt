package com.example.kadoc

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import org.orbitmvi.orbit.ContainerHost


abstract class BaseViewModel<STATE : Any, SIDE_EFFECT : Any> : ContainerHost<STATE, SIDE_EFFECT>,
    ViewModel() {
}
