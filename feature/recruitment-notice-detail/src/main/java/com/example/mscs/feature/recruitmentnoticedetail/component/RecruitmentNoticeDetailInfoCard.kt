package com.example.mscs.feature.recruitmentnoticedetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.militartservicecompanysearch.core.model.DueDateInfo
import com.example.militartservicecompanysearch.core.model.DueDateType
import com.example.militartservicecompanysearch.core.model.RecruitmentNotice
import com.example.mscs.feature.recruitmentnotice.component.DueDateTag
import com.example.mscs.feature.recruitmentnotice.component.MilitaryTypeChip
import kotlinx.datetime.LocalDate

@Composable
fun RecruitmentNoticeDetailInfoCard(
    recruitmentNotice: RecruitmentNotice,
    modifier: Modifier = Modifier
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("병역 정보", "업체 정보", "근무 정보")

    Column(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(16.dp)
    ) {
        Text(
            text = recruitmentNotice.companyName,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = recruitmentNotice.recruitmentTitle,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            MilitaryTypeChip(
                text = recruitmentNotice.militaryServiceType,
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )

            Spacer(modifier = Modifier.width(8.dp))

            MilitaryTypeChip(
                text = recruitmentNotice.personnel,
                containerColor = MaterialTheme.colorScheme.secondaryContainer
            )

            Spacer(modifier = Modifier.width(8.dp))

            DueDateTag(
                dueDateInfo = recruitmentNotice.dueDateInfo,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        HorizontalDivider(thickness = 1.dp)

        TabRow(
            selectedTabIndex = selectedTabIndex
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = {
                        Text(
                            text = title,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                )
            }
        }

        // 선택된 탭에 따라 내용 표시
        when (selectedTabIndex) {
            0 -> MilitaryInfo(recruitmentNotice = recruitmentNotice)
            1 -> CompanyInfo(recruitmentNotice = recruitmentNotice)
            2 -> WorkInfo(recruitmentNotice = recruitmentNotice)
        }
    }
}

@Composable
fun MilitaryInfo(recruitmentNotice: RecruitmentNotice) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
    ) {
        DetailRow(
            label = "요원 구분",
            value = recruitmentNotice.militaryServiceType
        )

        DetailRow(
            label = "역종",
            value = recruitmentNotice.personnel
        )

        DetailRow(
            label = "모집인원",
            value = recruitmentNotice.recruitmentCount
        )
    }
}

@Composable
fun CompanyInfo(recruitmentNotice: RecruitmentNotice) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
    ) {
        DetailRow(
            label = "업체명",
            value = recruitmentNotice.companyName
        )

        DetailRow(
            label = "업종",
            value = "${recruitmentNotice.sector} (${recruitmentNotice.jobPosition})"
        )

        DetailRow(
            label = "위치",
            value = recruitmentNotice.companyAddress
        )

        DetailRow(
            label = "홈페이지",
            value = recruitmentNotice.homePageLink ?: "-",
            isLink = true
        )

        DetailRow(
            label = "연락처",
            value = recruitmentNotice.companyPhoneNumber,
            isLink = true
        )

        DetailRow(
            label = "담당자",
            value = "${recruitmentNotice.manager} (${recruitmentNotice.managerPhoneNumber})"
        )
    }
}

@Composable
fun WorkInfo(recruitmentNotice: RecruitmentNotice) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
    ) {
        DetailRow(
            label = "직무",
            value = recruitmentNotice.jobPosition
        )

        DetailRow(
            label = "근무일",
            value = recruitmentNotice.workingDays
        )

        DetailRow(
            label = "급여",
            value = recruitmentNotice.salary
        )

        DetailRow(
            label = "학력",
            value = recruitmentNotice.highestEducation
        )

        DetailRow(
            label = "경력",
            value = recruitmentNotice.careerCategory
        )

        DetailRow(
            label = "복리후생",
            value = recruitmentNotice.welfareBenefits ?: "-"
        )

        DetailRow(
            label = "이력서 제출 방법",
            value = recruitmentNotice.submissionMethod ?: "-"
        )
    }
}

@Composable
fun DetailRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    isLink: Boolean = false
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {
        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium,
                color = if (isLink) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                fontWeight = if (isLink) FontWeight.Medium else FontWeight.Normal
            )
        }
    }
}

@Preview
@Composable
private fun MilitaryServiceInfoCardPreview() {
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
        dueDate = LocalDate(2025, 4, 25),
        dueDateInfo = DueDateInfo("~5/31", DueDateType.FUTURE),
        recruitmentCount = "2명",
        saeopjaDrno = "6098135829",
        personnelCode = "006",
        personnel = "현역",
        militaryServiceTypeCode = "1",
        militaryServiceType = "산업기능요원",
        validFlag = "Y",
    )

    RecruitmentNoticeDetailInfoCard(recruitmentNotice = sampleRecruitmentNotice)
}
