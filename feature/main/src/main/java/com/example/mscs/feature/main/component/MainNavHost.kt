package com.example.mscs.feature.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.example.mscs.feature.main.MainNavigator
import com.example.mscs.feature.recruitmentnotice.navigation.recruitmentNoticeNavGraph
import com.example.mscs.feature.recruitmentnoticedetail.navigation.navigateRecruitmentNoticeDetail
import com.example.mscs.feature.recruitmentnoticedetail.navigation.recruitmentNoticeDetailNavGraph

@Composable
internal fun MainNavHost(
    modifier: Modifier = Modifier,
    navigator: MainNavigator,
    padding: PaddingValues
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceDim)
    ) {
        NavHost(
            navController = navigator.navController,
            startDestination = navigator.startDestination,
        ) {
            recruitmentNoticeNavGraph(
                padding = padding,
                onRecruitmentNoticeClick = { recruitmentNo ->
                    navigator.navController.navigateRecruitmentNoticeDetail(recruitmentNo)
                }
            )
            recruitmentNoticeDetailNavGraph(
                padding = padding,
                onBackClick = {
                    navigator.navController.popBackStack()
                }
            )
        }
    }
}
