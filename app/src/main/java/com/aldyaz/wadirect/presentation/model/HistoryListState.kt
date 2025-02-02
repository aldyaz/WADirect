package com.aldyaz.wadirect.presentation.model

import com.aldyaz.wadirect.presentation.base.StateEventWithContent
import com.aldyaz.wadirect.presentation.base.StateEventWithContentConsumed

data class HistoryListState(
    val histories: List<HistoryPresentationModel> = emptyList(),
    val itemClickEvent: StateEventWithContent<String> = StateEventWithContentConsumed
) {

    companion object {
        val Initial = HistoryListState()
    }
}