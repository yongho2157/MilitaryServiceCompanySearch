package com.example.mscs.feature.recruitmentnotice.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.militaryservicecompanysearch.core.navigation.MainTabRoute
import com.example.mscs.feature.recruitmentnotice.RecruitmentNoticeRoute

fun NavController.navigateRecruitmentNotice(navOptions: NavOptions) {
    navigate(MainTabRoute.Recruitment, navOptions)
}

fun NavGraphBuilder.recruitmentNoticeNavGraph(
    padding: PaddingValues,
    onRecruitmentNoticeClick: (String) -> Unit

) {
    composable<MainTabRoute.Recruitment> {
        RecruitmentNoticeRoute(
            padding = padding,
            onRecruitmentNoticeClick = onRecruitmentNoticeClick,
        )
    }
}
