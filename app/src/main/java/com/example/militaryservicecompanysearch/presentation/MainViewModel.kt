package com.example.militaryservicecompanysearch.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.militaryservicecompanysearch.domain.model.DataError
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import com.example.militaryservicecompanysearch.domain.model.Result
import com.example.militaryservicecompanysearch.domain.repository.MilitaryServiceCompanyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val militaryServiceCompanyRepository: MilitaryServiceCompanyRepository
) : ViewModel() {
    private val _recruitmentNoticeList = MutableLiveData<List<RecruitmentNotice>>(emptyList())
    val recruitmentNoticeList: LiveData<List<RecruitmentNotice>>
        get() = _recruitmentNoticeList

    private val _selectedSectors = MutableStateFlow<List<String>>(emptyList())
    val selectedSectors: StateFlow<List<String>> = _selectedSectors

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

    private fun getLocalRecruitmentNotices() {
        viewModelScope.launch {
            militaryServiceCompanyRepository
                .getLocalRecruitmentNotices()
                .cachedIn(viewModelScope)
                .collect {
                    _allSellUiState.value = it
                }
        }
    }

    fun getRecruitmentNoticesByTitle(title: String) {
        viewModelScope.launch {
            militaryServiceCompanyRepository
                .getRecruitmentNoticesByTitle(title, _selectedSectors.value)
                .cachedIn(viewModelScope)
                .collect {
                    _allSellUiState.value = it
                }
        }
    }

    fun getRecruitmentNoticesBySector(sectors: List<String>) {
        viewModelScope.launch {
            militaryServiceCompanyRepository
                .getRecruitmentNoticesBySector(sectors)
                .cachedIn(viewModelScope)
                .collect {
                    _allSellUiState.value = it
                }
        }
    }


    fun addSector(type: String) {
        _selectedSectors.value.let { currentList ->
            if (!currentList.contains(type)) {
                _selectedSectors.value = currentList + type
            }
        }
    }

    fun clearSector() {
        _selectedSectors.value.let {
            _selectedSectors.value = emptyList()
        }
    }

}

