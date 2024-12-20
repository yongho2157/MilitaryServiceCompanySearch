package com.example.militaryservicecompanysearch.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.militaryservicecompanysearch.domain.usecase.GetRecruitmentNoticesUseCase
import com.example.militaryservicecompanysearch.domain.model.DataError
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import com.example.militaryservicecompanysearch.domain.model.Result
import com.example.militaryservicecompanysearch.domain.repository.MilitaryServiceCompanyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val militaryServiceCompanyRepository: MilitaryServiceCompanyRepository,
    private val getRecruitmentNoticesUseCase: GetRecruitmentNoticesUseCase
) : ViewModel() {
    private val _recruitmentNoticeList = MutableLiveData<List<RecruitmentNotice>>(emptyList())
    val recruitmentNoticeList: LiveData<List<RecruitmentNotice>>
        get() = _recruitmentNoticeList

    private val _selectedSectors = MutableStateFlow<List<String>>(emptyList())
    val selectedSectors: StateFlow<List<String>> = _selectedSectors

    val displaySectors = selectedSectors.map { sectors ->
        when {
            sectors.isEmpty() -> "업종선택"
            sectors.size == 1 -> sectors.first()
            else -> "${sectors.first()} 외 ${sectors.size - 1}"
        }
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        ""
    )

    private val _militaryServiceType = MutableStateFlow<String>("")
    val militaryServiceType: StateFlow<String> = _militaryServiceType

    private val _allSellUiState: MutableStateFlow<PagingData<RecruitmentNotice>> =
        MutableStateFlow(PagingData.empty())
    val allSellUiState = _allSellUiState.asStateFlow()

    init {
        getRecruitmentNotices()
        getLocalRecruitmentNotices()
    }

    private fun getRecruitmentNotices() {
        viewModelScope.launch {
            when (val result = militaryServiceCompanyRepository.getRecruitmentNotices()) {
                is Result.Error -> {
                    when (result.error) {
                        DataError.Network.REQUEST_TIMEOUT -> TODO()
                        DataError.Network.NO_INTERNET -> TODO()
                        DataError.Network.SERVER_ERROR -> TODO()
                        DataError.Network.UNKNOWN -> TODO()
                    }
                }

                is Result.Success -> {
                    _recruitmentNoticeList.value = result.data
                }
            }
        }
    }

    fun getLocalRecruitmentNotices() {
        viewModelScope.launch {
            getRecruitmentNoticesUseCase(
                sectors = _selectedSectors.value,
                militaryServiceType = _militaryServiceType.value,
                pagingConfig = PagingConfig(
                    pageSize = 10,
                    initialLoadSize = 30
                )
            )
                .cachedIn(viewModelScope)
                .collect {
                    _allSellUiState.value = it
                }
        }
    }

    fun setMilitaryServiceType(type: String) {
        _militaryServiceType.value = type
    }

    fun addSector(type: String) {
        _selectedSectors.value.let { currentList ->
            if (!currentList.contains(type)) {
                _selectedSectors.value = currentList + type
            }
        }
    }

    fun removeSector(type: String) {
        _selectedSectors.update { currentList ->
            currentList.filter { it != type }
        }
    }

}

