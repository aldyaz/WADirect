package com.aldyaz.wadirect.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.aldyaz.wadirect.domain.base.ResultState
import com.aldyaz.wadirect.domain.interactor.FormatPhoneOnlyUseCase
import com.aldyaz.wadirect.domain.interactor.GetPhoneCountryCodesUseCase
import com.aldyaz.wadirect.domain.interactor.SavePhoneToHistoryUseCase
import com.aldyaz.wadirect.domain.model.param.FormatPhoneParamDomainModel
import com.aldyaz.wadirect.domain.model.param.PhoneHistoryParamDomainModel
import com.aldyaz.wadirect.presentation.base.BaseViewModel
import com.aldyaz.wadirect.presentation.base.StateEventWithContentConsumed
import com.aldyaz.wadirect.presentation.base.StateEventWithContentTriggered
import com.aldyaz.wadirect.presentation.mapper.CountryCodeToPresentationMapper
import com.aldyaz.wadirect.presentation.model.MainIntent
import com.aldyaz.wadirect.presentation.model.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.updateAndGet
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPhoneCountryCodesUseCase: GetPhoneCountryCodesUseCase,
    private val formatPhoneOnlyUseCase: FormatPhoneOnlyUseCase,
    private val savePhoneToHistoryUseCase: SavePhoneToHistoryUseCase,
    private val countryCodeToPresentationMapper: CountryCodeToPresentationMapper
) : BaseViewModel<MainIntent>() {

    private val _state = MutableStateFlow(MainState.INITIAL)
    val state = combine(
        _state,
        flow { emit(getPhoneCountryCodesUseCase(Unit)) }
    ) { state, countryCodesResult ->
        when (countryCodesResult) {
            is ResultState.Success -> {
                val data = List(countryCodesResult.data.size) {
                    countryCodeToPresentationMapper(countryCodesResult.data[it])
                }
                if (state.countryCodes != data) {
                    state.copy(
                        loading = true,
                        error = false,
                        countryCodes = data
                    )
                } else {
                    state
                }
            }

            is ResultState.Error -> {
                state.copy(
                    loading = false,
                    error = true
                )
            }
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = MainState.INITIAL
    )

    private fun cleanPhone(state: MainState) = viewModelScope.launch(Dispatchers.IO) {
        val param = FormatPhoneParamDomainModel(
            dialCode = state.countryCode.dialCode,
            phone = state.phone
        )
        formatPhoneOnlyUseCase(param)/*.flatMapLatest { phone ->
            savePhoneToHistoryUseCase(
                PhoneHistoryParamDomainModel(
                    dialCode = param.dialCode,
                    phone = param.phone
                )
            ).flatMapLatest {
                flowOf(phone)
            }
        }*/.collect { newPhone ->
            _state.update {
                it.copy(
                    phoneSubmitEvent = StateEventWithContentTriggered(newPhone)
                )
            }
        }
    }

    override fun onIntentReceived(intent: MainIntent) {
        when (intent) {
            is MainIntent.OpenCountryCodeBottomSheet -> {
                _state.update {
                    it.copy(
                        isChoosingCountryCode = true
                    )
                }
            }

            is MainIntent.DismissCountryCodeBottomSheet -> {
                _state.update {
                    it.copy(
                        isChoosingCountryCode = false
                    )
                }
            }

            is MainIntent.SelectCountryCode -> {
                _state.update {
                    it.copy(
                        countryCode = intent.countryCode
                    )
                }
            }

            is MainIntent.PhoneSubmission -> {
                val newState = _state.updateAndGet {
                    it.copy(
                        countryCode = intent.countryCode,
                        phone = intent.phone
                    )
                }
                cleanPhone(newState)
            }

            is MainIntent.OnConsumedPhoneSubmitEvent -> {
                _state.update {
                    it.copy(
                        phoneSubmitEvent = StateEventWithContentConsumed
                    )
                }
            }
        }
    }
}