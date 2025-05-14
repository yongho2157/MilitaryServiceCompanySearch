package com.example.mscs.feature.model

import androidx.paging.PagingData
import com.example.militartservicecompanysearch.core.model.RecruitmentNotice
import kotlinx.coroutines.flow.Flow

sealed interface RecruitmentUiState {
    data object Loading : RecruitmentUiState
    data class Success(
        val recruitmentNotices: Flow<PagingData<RecruitmentNotice>>
    ) : RecruitmentUiState

}
