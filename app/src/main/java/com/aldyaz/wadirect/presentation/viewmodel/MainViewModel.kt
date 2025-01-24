package com.aldyaz.wadirect.presentation.viewmodel

import com.aldyaz.wadirect.presentation.base.BaseViewModel
import com.aldyaz.wadirect.presentation.base.StateEventWithContent
import com.aldyaz.wadirect.presentation.base.StateEventWithContentConsumed
import com.aldyaz.wadirect.presentation.base.StateEventWithContentTriggered
import com.aldyaz.wadirect.presentation.model.MainIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel<MainIntent>() {

    private val _phoneSubmitEvent: MutableStateFlow<StateEventWithContent<String>> =
        MutableStateFlow(StateEventWithContentConsumed)

    val phoneSubmitEvent: StateFlow<StateEventWithContent<String>>
        get() = _phoneSubmitEvent.asStateFlow()

    override fun onIntentReceived(intent: MainIntent) {
        when (intent) {
            is MainIntent.LaunchWhatsApp -> {
                _phoneSubmitEvent.update {
                    StateEventWithContentTriggered(intent.phone)
                }
            }

            is MainIntent.OnConsumedPhoneSubmitEvent -> {
                _phoneSubmitEvent.update { StateEventWithContentConsumed }
            }
        }
    }
}