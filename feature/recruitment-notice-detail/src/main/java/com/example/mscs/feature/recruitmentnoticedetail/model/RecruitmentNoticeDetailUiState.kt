package com.example.mscs.feature.recruitmentnoticedetail.model

import com.example.militartservicecompanysearch.core.model.RecruitmentNotice

sealed interface RecruitmentNoticeDetailUiState {
    data object Loading : RecruitmentNoticeDetailUiState
    data class Success(
        val recruitmentNotice: RecruitmentNotice
    ) : RecruitmentNoticeDetailUiState

}
