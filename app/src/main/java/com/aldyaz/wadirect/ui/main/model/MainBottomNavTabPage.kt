package com.aldyaz.wadirect.ui.main.model

import com.aldyaz.wadirect.ui.main.page.MainHistoryTabScreen
import com.aldyaz.wadirect.ui.main.page.MainHomeTabScreen

sealed class MainBottomNavTabPage(
    val route: Any,
    val type: MainTabType
) {

    data object HomeTabPage : MainBottomNavTabPage(
        route = MainHomeTabScreen,
        type = MainTabType.HOME
    )

    data object HistoryTabPage : MainBottomNavTabPage(
        route = MainHistoryTabScreen,
        type = MainTabType.HISTORY
    )

}