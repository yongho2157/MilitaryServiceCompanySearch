package com.example.mscs.feature.recruitment.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.militaryservicecompanysearch.core.navigation.MainTabRoute
import com.example.mscs.feature.recruitment.RecruitmentRoute

fun NavController.navigateRecruitment(navOptions: NavOptions) {
    navigate(MainTabRoute.Recruitment, navOptions)
}

fun NavGraphBuilder.recruitmentNavGraph(
    padding: PaddingValues
) {
    composable<MainTabRoute.Recruitment> {
        RecruitmentRoute(padding)
    }
}
