package com.example.militaryservicecompanysearch.domain.usecase

import android.util.Log
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
        personnel: String,
        pagingConfig: PagingConfig
    ): Flow<PagingData<RecruitmentNotice>> {
        val militaryServiceTypeCode = MilitaryServiceType.fromCode(militaryServiceType)
        val personnelCode = Personnel.fromCode(personnel)
        Log.d("결과", "militaryServiceTypeCode: $militaryServiceTypeCode")
        Log.d("결과", "personnelCode: $personnelCode")

        return militaryServiceCompanyRepository.getLocalRecruitmentNotices(
            sectors = sectors,
            militaryServiceTypeCode = militaryServiceTypeCode,
            personnelCode = personnelCode,
            pagingConfig = pagingConfig
        )
    }

}
