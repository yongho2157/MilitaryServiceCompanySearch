package com.example.mscs.feature.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mscs.feature.main.component.MainBottomBar
import com.example.mscs.feature.main.component.MainNavHost
import kotlinx.collections.immutable.toPersistentList

@Composable
internal fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator()
) {
    MainScreenContent(navigator = navigator)
}

@Composable
private fun MainScreenContent(
    modifier: Modifier = Modifier,
    navigator: MainNavigator
) {
    Scaffold(
        modifier = modifier,
        content = { padding ->
            MainNavHost(
                navigator = navigator,
                padding = padding
            )
        },
        bottomBar = {
            MainBottomBar(
                tabs = MainTab.entries.toPersistentList(),
                currentTab = null,
                onTabSelected = { navigator.navigate(it) },
            )
        }
    )
}
