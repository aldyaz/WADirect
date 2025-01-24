package com.aldyaz.wadirect.ui.common.effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.NonRestartableComposable
import com.aldyaz.wadirect.presentation.base.StateEvent
import com.aldyaz.wadirect.presentation.base.StateEventWithContent
import com.aldyaz.wadirect.presentation.base.StateEventWithContentTriggered

/**
 * Credit to Leonard Palm (https://github.com/leonard-palm)
 * The code below is from his compose-state-events library:
 * https://github.com/leonard-palm/compose-state-events
 */

@Composable
@NonRestartableComposable
fun EventEffect(
    event: StateEvent,
    onConsumed: () -> Unit,
    action: suspend () -> Unit
) {
    LaunchedEffect(event) {
        if (event is StateEvent.Triggered) {
            action()
            onConsumed()
        }
    }
}

@Composable
@NonRestartableComposable
fun <T> EventEffect(
    event: StateEventWithContent<T>,
    onConsumed: () -> Unit,
    action: suspend (T) -> Unit
) {
    LaunchedEffect(event) {
        if (event is StateEventWithContentTriggered<T>) {
            action(event.content)
            onConsumed()
        }
    }
}
