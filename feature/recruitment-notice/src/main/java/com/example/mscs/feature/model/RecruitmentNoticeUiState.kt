package com.example.mscs.feature.model

import androidx.paging.PagingData
import com.example.militartservicecompanysearch.core.model.RecruitmentNotice
import kotlinx.coroutines.flow.Flow

sealed interface RecruitmentNoticeUiState {
    data object Loading : RecruitmentNoticeUiState
    data class Success(
        val recruitmentNotices: Flow<PagingData<RecruitmentNotice>>
    ) : RecruitmentNoticeUiState

}
