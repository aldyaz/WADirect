package com.aldyaz.wadirect.ui.main.model

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.aldyaz.wadirect.R

enum class MainTabType(
    @StringRes
    val title: Int,
    val icon: ImageVector
) {
    HOME(
        title = R.string.label_home,
        icon = Icons.Default.Home
    ),
    HISTORY(
        title = R.string.label_history,
        icon = Icons.Default.History
    )
}