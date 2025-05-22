package com.example.mscs.feature.recruitmentnoticedetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mscs.core.designsystem.component.MscsTopAppBar
import com.example.mscs.feature.recruitmentnoticedetail.component.RecruitmentDetailErrorContent
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
        recruitmentNoticeUiState = recruitmentNoticeUiState,
        onBackClick = onBackClick
    )

    LaunchedEffect(recruitmentNo) {
        viewModel.getRecruitmentNoticeDetail(recruitmentNo)
    }
}

@Composable
private fun RecruitmentNoticeDetailScreen(
    padding: PaddingValues,
    recruitmentNoticeUiState: RecruitmentNoticeDetailUiState,
    onBackClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(padding)
            .background(Color.White)
            .fillMaxSize()
    ) {
        MscsTopAppBar(
            titleRes = R.string.detail_tob_bar_title,
            onBackClick = onBackClick
        )
        Box {
            when (recruitmentNoticeUiState) {
                RecruitmentNoticeDetailUiState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                is RecruitmentNoticeDetailUiState.Success -> {
                    RecruitmentNoticeDetailInfoCard(recruitmentNoticeUiState.recruitmentNotice)
                }

                is RecruitmentNoticeDetailUiState.Error -> {
                    RecruitmentDetailErrorContent(recruitmentNoticeUiState.message)
                }
            }
        }
    }
}
