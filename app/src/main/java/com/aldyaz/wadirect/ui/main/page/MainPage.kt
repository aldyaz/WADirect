@file:OptIn(ExperimentalMaterial3Api::class)

package com.aldyaz.wadirect.ui.main.page

import android.widget.Toast
import androidx.activity.compose.LocalActivity
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aldyaz.wadirect.di.PlatformEntryPoint
import com.aldyaz.wadirect.presentation.model.MainIntent
import com.aldyaz.wadirect.presentation.viewmodel.MainViewModel
import com.aldyaz.wadirect.ui.common.effect.EventEffect
import com.aldyaz.wadirect.ui.main.model.MainBottomNavTabPage
import dagger.hilt.android.EntryPointAccessors

@Composable
fun MainPage(
    viewModel: MainViewModel = hiltViewModel()
) {
    val activity = LocalActivity.current
    var platformEntryPoint: PlatformEntryPoint? = null
    if (activity != null) {
        platformEntryPoint = remember {
            EntryPointAccessors.fromActivity(activity, PlatformEntryPoint::class.java)
        }
    }
    val whatsAppLaunchManager = platformEntryPoint?.whatsAppLaunchManager()

    val phoneSubmitEvent by viewModel.phoneSubmitEvent.collectAsStateWithLifecycle()

    EventEffect(
        event = phoneSubmitEvent,
        onConsumed = { viewModel.onIntentReceived(MainIntent.OnConsumedPhoneSubmitEvent) }
    ) { phone ->
        val isLaunched = whatsAppLaunchManager?.launch(phone)
        Toast.makeText(
            activity,
            if (isLaunched == true) "Launched!" else "Not launched!",
            Toast.LENGTH_SHORT
        ).show()
    }

    MainScaffold(hiltViewModel())
}

@Composable
private fun MainScaffold(
    sharedViewModel: MainViewModel
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            MainBottomBar(
                navController = navController,
                tabs = arrayOf(
                    MainBottomNavTabPage.HomeTabPage,
                    MainBottomNavTabPage.HistoryTabPage
                )
            )
        },
        content = { contentPadding ->
            MainContent(
                navController = navController,
                sharedViewModel = sharedViewModel,
                modifier = Modifier
                    .padding(contentPadding)
                    .fillMaxSize()
            )
        }
    )
}

@Composable
private fun MainContent(
    navController: NavHostController,
    sharedViewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = MainHomeTabScreen,
        route = MainParentScreen::class,
        enterTransition = { fadeIn(animationSpec = tween(500)) },
        exitTransition = { fadeOut(animationSpec = tween(500)) },
        modifier = modifier
    ) {
        composable<MainHomeTabScreen> {
            MainHomeTab(
                sharedViewModel = sharedViewModel
            )
        }

        composable<MainHistoryTabScreen> { backStackEntry ->
            MainHistoryTab()
        }
    }
}

@Composable
fun MainBottomBar(
    navController: NavController,
    tabs: Array<MainBottomNavTabPage>
) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        tabs.forEach { page ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.hasRoute(page.route::class) } == true,
                onClick = {
                    navController.navigate(page.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = page.type.icon,
                        contentDescription = stringResource(page.type.title)
                    )
                },
                label = {
                    Text(stringResource(page.type.title))
                }
            )
        }
    }
}
