package com.example.mscs.feature.recruitmentnotice.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.militartservicecompanysearch.core.model.DueDateInfo
import com.example.militartservicecompanysearch.core.model.DueDateType
import com.example.militartservicecompanysearch.core.model.RecruitmentNotice
import com.example.mscs.feature.recruitmentnotice.R
import kotlinx.datetime.LocalDate

@Composable
fun RecruitmentNoticeInfoCard(
    recruitmentNotice: RecruitmentNotice,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {},
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(170.dp)
            .
            clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = true),
                onClick = { onClick(recruitmentNotice.recruitmentNo) }
            )

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = recruitmentNotice.companyName,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.LocationOn,
                        contentDescription = stringResource(R.string.recruitment_location_contentDescription),
                        tint = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = recruitmentNotice.location,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = recruitmentNotice.recruitmentTitle,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
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
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = "${recruitmentNotice.careerCategory} · ${recruitmentNotice.recruitmentCount}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                }

                DueDateTag(
                    dueDateInfo = recruitmentNotice.dueDateInfo,
                )
            }
        }
    }
}


@Preview
@Composable
private fun RecruitmentNoticeInfoCardPreview() {
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

    RecruitmentNoticeInfoCard(
        recruitmentNotice = sampleRecruitmentNotice
    )
}
