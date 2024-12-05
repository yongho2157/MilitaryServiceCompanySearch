package com.example.militaryservicecompanysearch.domain.usecase

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.militaryservicecompanysearch.domain.enums.MilitaryServiceType
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import com.example.militaryservicecompanysearch.domain.repository.MilitaryServiceCompanyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecruitmentNoticesUseCase @Inject constructor(
    private val militaryServiceCompanyRepository: MilitaryServiceCompanyRepository
) {

    operator fun invoke(
        sectors: List<String>,
        militaryServiceType: String,
        pagingConfig: PagingConfig
    ): Flow<PagingData<RecruitmentNotice>> {
        val militaryServiceTypeCode = MilitaryServiceType.getCodeByType(militaryServiceType)

        return militaryServiceCompanyRepository.getLocalRecruitmentNotices(
            sectors = sectors,
            militaryServiceTypeCode = militaryServiceTypeCode,
            pagingConfig = pagingConfig
        )
    }

}
