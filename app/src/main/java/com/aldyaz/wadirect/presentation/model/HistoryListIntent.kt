package com.aldyaz.wadirect.presentation.model

sealed class HistoryListIntent {

    data class ItemClick(
        val phone: String
    ): HistoryListIntent()

    data object OnConsumedItemClickEvent : HistoryListIntent()

}
