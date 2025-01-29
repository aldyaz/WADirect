package com.aldyaz.wadirect.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.aldyaz.wadirect.domain.interactor.GetSentHistoriesUseCase
import com.aldyaz.wadirect.presentation.base.BaseViewModel
import com.aldyaz.wadirect.presentation.model.HistoryListIntent
import com.aldyaz.wadirect.presentation.model.HistoryListState
import com.aldyaz.wadirect.presentation.model.HistoryPresentationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HistoryListViewModel @Inject constructor(
    getSentHistoriesUseCase: GetSentHistoriesUseCase
) : BaseViewModel<HistoryListIntent>() {

    private val _state = MutableStateFlow(HistoryListState.Initial)
    val state = combine(
        _state,
        getSentHistoriesUseCase(Unit)
    ) { state, histories ->
        state.copy(
            histories = List(histories.size) { index ->
                val history = histories[index]
                HistoryPresentationModel(
                    phone = history.phone,
                    date = history.timestamp
                )
            }
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = HistoryListState.Initial
    )

    override fun onIntentReceived(intent: HistoryListIntent) {
    }
}