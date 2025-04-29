package com.example.militaryservicecompanysearch.core.domain.usecase

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.militartservicecompanysearch.core.model.RecruitmentNotice
import com.example.militaryservicecompanysearch.core.domain.enums.MilitaryServiceType
import com.example.militaryservicecompanysearch.core.domain.repository.MilitaryServiceCompanyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecruitmentNoticesUseCase @Inject constructor(
    private val militaryServiceCompanyRepository: MilitaryServiceCompanyRepository
) {

    operator fun invoke(
        sectors: List<String>,
        militaryServiceType: String,
        personnel: String,
        pagingConfig: PagingConfig
    ): Flow<PagingData<RecruitmentNotice>> {
        val militaryServiceTypeCode = MilitaryServiceType.fromCode(militaryServiceType)
        val personnelCode = Personnel.fromCode(personnel)

        return militaryServiceCompanyRepository.getLocalRecruitmentNotices(
            sectors = sectors,
            militaryServiceTypeCode = militaryServiceTypeCode,
            personnelCode = personnelCode,
            pagingConfig = pagingConfig
        )
    }

}
