package com.example.mscs.feature.recruitmentnoticedetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mscs.feature.recruitmentnoticedetail.component.RecruitmentNoticeDetailInfoCard
import com.example.mscs.feature.recruitmentnoticedetail.model.RecruitmentNoticeDetailUiState

@Composable
internal fun RecruitmentNoticeDetailRoute(
    padding: PaddingValues,
    recruitmentNo: String,
    onBackClick: () -> Unit,
    viewModel: RecruitmentNoticeDetailViewModel = hiltViewModel(),
) {
    val recruitmentNoticeUiState by viewModel.recruitmentNoticeDetailUiState.collectAsState()

    RecruitmentNoticeDetailScreen(
        padding = padding,
        recruitmentNoticeUiState = recruitmentNoticeUiState
    )

    LaunchedEffect(recruitmentNo) {
        viewModel.getRecruitmentNoticeDetail(recruitmentNo)
    }
}

@Composable
private fun RecruitmentNoticeDetailScreen(
    padding: PaddingValues,
    recruitmentNoticeUiState: RecruitmentNoticeDetailUiState
) {
    Box(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
    ) {
        when (recruitmentNoticeUiState) {
            RecruitmentNoticeDetailUiState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            is RecruitmentNoticeDetailUiState.Success -> {
                RecruitmentNoticeDetailInfoCard(recruitmentNoticeUiState.recruitmentNotice)
            }
        }
    }
}
