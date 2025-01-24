package com.aldyaz.wadirect.presentation.base

import androidx.compose.runtime.Immutable

/**
 * Credit to Leonard Palm (https://github.com/leonard-palm)
 * The code below is from his compose-state-events library:
 * https://github.com/leonard-palm/compose-state-events
 */

@Immutable
sealed class StateEvent {

    @Immutable
    data object Triggered : StateEvent() {
        override fun toString(): String = "triggered"
    }

    @Immutable
    data object Consumed : StateEvent() {
        override fun toString(): String = "consumed"
    }
}