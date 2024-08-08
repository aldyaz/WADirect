package com.aldyaz.wadirect.presentation.model

sealed class MainIntent {

    data object OnEnter : MainIntent()

}