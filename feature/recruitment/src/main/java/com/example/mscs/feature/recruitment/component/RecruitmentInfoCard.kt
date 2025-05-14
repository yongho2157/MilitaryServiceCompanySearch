package com.example.mscs.feature.recruitment.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.militartservicecompanysearch.core.model.RecruitmentNotice

@Composable
fun RecruitmentInfoCard(
    recruitmentNotice: RecruitmentNotice,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(
            width = 1.dp,
            color = Color.Black
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(150.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = recruitmentNotice.companyName,
                fontSize = 14.sp
            )

            Text(
                text = recruitmentNotice.recruitmentTitle,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = recruitmentNotice.jobPosition,
                fontSize = 14.sp
            )
            Text(
                text = recruitmentNotice.dueDate,
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}

@Preview
@Composable
private fun RecruitmentInfoCardPreview() {
    val sampleRecruitmentNotice = RecruitmentNotice(
        welfareBenefits = "국민연금, 고용보험, 산재보험, 건강보험, 연차, 정기휴가, 향후정직원, 건강검진, 사원식당",
        registrationDate = "20250401",
        lastModifiedDate = "20250425",
        highestEducation = "고등학교졸업",
        recruitmentNo = "2000000985300",
        recruitmentTitle = "제조업체 현역 모집",
        manager = "김수정",
        jobPosition = "생산업무 (MCT가공)",
        managerPhoneNumber = "055-252-8998",
        companyPhoneNumber = "055-252-8998",
        companyName = "우창기계(주)",
        sectorCode = "11102",
        sector = "기계",
        companyAddress = "경상남도 창원시 성산구 신촌동",
        location = "경상남도",
        workingDays = "주5일",
        locationCode = "4812312300",
        careerPeriod = null,
        careerCategory = "신입/경력",
        salaryCode = "13",
        salary = "3400~3600만원",
        homePageLink = null,
        submissionMethod = "병역일터 이력서",
        companyAddressCode = "4812312300",
        dueDate = "20250531",
        recruitmentCount = "2명",
        saeopjaDrno = "6098135829",
        personnelCode = "006",
        personnel = "현역",
        militaryServiceTypeCode = "1",
        militaryServiceType = "산업기능요원",
        validFlag = "Y",
    )

    RecruitmentInfoCard(
        recruitmentNotice = sampleRecruitmentNotice
    )
}
