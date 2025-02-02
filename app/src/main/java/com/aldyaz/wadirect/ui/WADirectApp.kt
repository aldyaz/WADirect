package com.aldyaz.wadirect.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aldyaz.wadirect.ui.common.WADirectTheme
import com.aldyaz.wadirect.ui.main.page.HistoryListPage
import com.aldyaz.wadirect.ui.main.page.HistoryScreen
import com.aldyaz.wadirect.ui.main.page.MainPage
import com.aldyaz.wadirect.ui.main.page.MainScreen

@Composable
fun WADirectApp() {
    WADirectTheme {
        AppNavigation()
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MainScreen
    ) {
        composable<MainScreen> {
            MainPage(
                onClickHistory = {
                    navController.navigate(HistoryScreen)
                }
            )
        }

        composable<HistoryScreen> {
            HistoryListPage(
                onNavigateUp = navController::navigateUp
            )
        }
    }
}
