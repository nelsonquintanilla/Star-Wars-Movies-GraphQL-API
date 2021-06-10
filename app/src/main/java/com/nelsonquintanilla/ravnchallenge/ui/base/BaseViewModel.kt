package com.nelsonquintanilla.ravnchallenge.ui.base

import androidx.lifecycle.ViewModel
import com.nelsonquintanilla.ravnchallenge.ui.util.launch
import org.koin.core.KoinComponent

abstract class BaseViewModel : ViewModel(), KoinComponent {

    fun executeUseCase(action: suspend () -> Unit) {
        launch { action() }
    }
}