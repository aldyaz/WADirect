package com.aldyaz.wadirect.presentation.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<INTENT> : ViewModel() {

    abstract fun onIntentReceived(intent: INTENT)

}