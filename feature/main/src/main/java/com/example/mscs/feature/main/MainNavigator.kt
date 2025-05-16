package com.example.mscs.feature.main

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.mscs.feature.recruitmentnotice.navigation.navigateRecruitmentNotice

internal class MainNavigator(
    val navController: NavHostController
) {
    val startDestination = MainTab.Recruitment.route

    fun navigate(tab: MainTab) {
        val navOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (tab) {
            MainTab.Recruitment -> navController.navigateRecruitmentNotice(navOptions)
            MainTab.Favorite -> {
                Log.d("결과", "navigate: MainTab.Favorite")
            }
            MainTab.Search -> {
                Log.d("결과", "navigate: MainTab.Search")
            }
        }
    }
}

@Composable
internal fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}

