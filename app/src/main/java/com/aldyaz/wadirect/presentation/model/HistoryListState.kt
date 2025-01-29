package com.aldyaz.wadirect.presentation.model

data class HistoryListState(
    val histories: List<HistoryPresentationModel> = emptyList()
) {

    companion object {
        val Initial = HistoryListState()
    }
}