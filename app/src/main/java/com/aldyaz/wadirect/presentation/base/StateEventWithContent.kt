package com.aldyaz.wadirect.presentation.base

import androidx.compose.runtime.Immutable

/**
 * Credit to Leonard Palm (https://github.com/leonard-palm)
 * The code below is from his compose-state-events library:
 * https://github.com/leonard-palm/compose-state-events
 */

@Immutable
sealed interface StateEventWithContent<out T>

@Immutable
data class StateEventWithContentTriggered<T>(
    val content: T
) : StateEventWithContent<T> {

    override fun toString(): String = "triggered: $content"
}

@Immutable
data object StateEventWithContentConsumed : StateEventWithContent<Nothing> {

    override fun toString(): String = "consumed"
}
