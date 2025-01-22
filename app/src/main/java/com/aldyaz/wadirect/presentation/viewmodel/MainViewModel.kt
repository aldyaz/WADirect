package com.aldyaz.wadirect.presentation.viewmodel

import com.aldyaz.wadirect.presentation.base.BaseViewModel
import com.aldyaz.wadirect.presentation.model.MainIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel<MainIntent>() {

    private val _phone = MutableStateFlow("")
    val phone: StateFlow<String>
        get() = _phone.asStateFlow()

    override fun onIntentReceived(intent: MainIntent) {
        when (intent) {
            is MainIntent.LaunchWhatsApp -> {
                _phone.update { curr ->
                    if (curr != intent.phone) {
                        intent.phone
                    } else {
                        curr
                    }
                }
            }
        }
    }
}