package com.example.mscs.feature.recruitmentnoticedetail.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.militaryservicecompanysearch.core.navigation.Route
import com.example.mscs.feature.recruitmentnoticedetail.RecruitmentNoticeDetailRoute


fun NavController.navigateRecruitmentNoticeDetail(recruitmentNo: String) {
    navigate(Route.RecruitmentNoticeDetail(recruitmentNo))
}

fun NavGraphBuilder.recruitmentNoticeDetailNavGraph(
    padding: PaddingValues,
    onBackClick: () -> Unit
) {
    composable<Route.RecruitmentNoticeDetail> { navBackStackEntry ->
        val recruitmentNo = navBackStackEntry.toRoute<Route.RecruitmentNoticeDetail>().recruitmentNo
        RecruitmentNoticeDetailRoute(
            padding = padding,
            recruitmentNo = recruitmentNo,
            onBackClick = onBackClick
        )
    }
}
