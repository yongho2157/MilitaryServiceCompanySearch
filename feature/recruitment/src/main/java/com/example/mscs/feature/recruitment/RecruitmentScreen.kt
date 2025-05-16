package com.example.mscs.feature.recruitment

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.mscs.feature.model.RecruitmentUiState
import com.example.mscs.feature.recruitment.component.RecruitmentInfoCard

@Composable
internal fun RecruitmentRoute(
    padding: PaddingValues,
    viewModel: RecruitmentViewModel = hiltViewModel(),
) {
    val recruitmentUiState by viewModel.recruitmentUiState.collectAsState()

    RecruitmentScreen(
        padding = padding,
        recruitmentUiState = recruitmentUiState
    )
}
@Composable
private fun RecruitmentScreen(
    padding: PaddingValues,
    recruitmentUiState: RecruitmentUiState
) {
    Box(
        modifier = Modifier
        .padding(padding)
        .fillMaxSize()
    ) {
        when (recruitmentUiState) {
            RecruitmentUiState.Loading -> {

            }
            is RecruitmentUiState.Success -> {
                val recruitmentNotices = recruitmentUiState.recruitmentNotices.collectAsLazyPagingItems()
                if(recruitmentNotices.loadState.refresh is LoadState.Loading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                } else {
                    LazyColumn {
                        items(recruitmentNotices.itemCount) { index ->
                            val recruitmentNotice = recruitmentNotices[index]
                            if (recruitmentNotice != null) {
                                RecruitmentInfoCard(recruitmentNotice)
                            }
                        }
                        item {
                            if(recruitmentNotices.loadState.append is LoadState.Loading) {
                                CircularProgressIndicator()
                            }
                        }
                    }
                }
            }
        }
    }
}
