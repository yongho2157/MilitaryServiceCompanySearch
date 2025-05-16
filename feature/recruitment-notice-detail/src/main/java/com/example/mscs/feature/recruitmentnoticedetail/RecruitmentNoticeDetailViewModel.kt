package com.example.mscs.feature.recruitmentnoticedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.militaryservicecompanysearch.core.domain.usecase.GetRecruitmentNoticeDetailUseCase
import com.example.mscs.feature.recruitmentnoticedetail.model.RecruitmentNoticeDetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecruitmentNoticeDetailViewModel @Inject constructor(
    private val getRecruitmentNoticeDetailUseCase: GetRecruitmentNoticeDetailUseCase
) : ViewModel() {

    private val _recruitmentNoticeDetailUiState =
        MutableStateFlow<RecruitmentNoticeDetailUiState>(RecruitmentNoticeDetailUiState.Loading)
    val recruitmentNoticeDetailUiState = _recruitmentNoticeDetailUiState.asStateFlow()

    fun getRecruitmentNoticeDetail(recruitmentNo: String) =
        viewModelScope.launch {
            val recruitmentNotice = getRecruitmentNoticeDetailUseCase(recruitmentNo)
            _recruitmentNoticeDetailUiState.value = RecruitmentNoticeDetailUiState.Success(
                recruitmentNotice = recruitmentNotice
            )
        }
}
