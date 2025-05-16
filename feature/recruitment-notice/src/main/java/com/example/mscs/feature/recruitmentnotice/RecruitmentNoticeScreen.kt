package com.example.mscs.feature.recruitmentnotice

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.mscs.feature.model.RecruitmentNoticeUiState
import com.example.mscs.feature.recruitmentnotice.component.RecruitmentNoticeInfoCard

@Composable
internal fun RecruitmentNoticeRoute(
    padding: PaddingValues,
    viewModel: RecruitmentViewModel = hiltViewModel(),
    onRecruitmentNoticeClick: (String) -> Unit
) {
    val recruitmentNoticeUiState by viewModel.recruitmentNoticeUiState.collectAsState()

    RecruitmentNoticeScreen(
        padding = padding,
        recruitmentUiState = recruitmentNoticeUiState,
        onRecruitmentNoticeClick = onRecruitmentNoticeClick
    )
}

@Composable
private fun RecruitmentNoticeScreen(
    padding: PaddingValues,
    recruitmentUiState: RecruitmentNoticeUiState,
    onRecruitmentNoticeClick: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
    ) {
        when (recruitmentUiState) {
            RecruitmentNoticeUiState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            is RecruitmentNoticeUiState.Success -> {
                val recruitmentNotices =
                    recruitmentUiState.recruitmentNotices.collectAsLazyPagingItems()
                if (recruitmentNotices.loadState.refresh is LoadState.Loading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                } else {
                    LazyColumn {
                        items(recruitmentNotices.itemCount) { index ->
                            val recruitmentNotice = recruitmentNotices[index]
                            if (recruitmentNotice != null) {
                                RecruitmentNoticeInfoCard(
                                    recruitmentNotice = recruitmentNotice,
                                    onClick = onRecruitmentNoticeClick
                                )
                            }
                        }
                        item {
                            if (recruitmentNotices.loadState.append is LoadState.Loading) {
                                CircularProgressIndicator()
                            }
                        }
                    }
                }
            }
        }
    }
}
