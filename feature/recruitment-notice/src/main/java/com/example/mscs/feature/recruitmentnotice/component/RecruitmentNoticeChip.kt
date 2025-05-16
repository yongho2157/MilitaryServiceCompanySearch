package com.example.mscs.feature.recruitmentnotice.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.militartservicecompanysearch.core.model.DueDateInfo
import com.example.militartservicecompanysearch.core.model.DueDateType

@Composable
fun MilitaryTypeChip(
    text: String,
    containerColor: Color,
    contentColor: Color = contentColorFor(containerColor)
) {
    Surface(
        shape = RoundedCornerShape(4.dp),
        color = containerColor,
        contentColor = contentColor
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}

@Composable
fun DueDateTag(
    dueDateInfo: DueDateInfo
) {
    Surface(
        shape = RoundedCornerShape(4.dp),
        color = dueDateInfo.type.backgroundColor()
    ) {
        Text(
            text = dueDateInfo.text,
            style = MaterialTheme.typography.labelMedium,
            color = dueDateInfo.type.color(),
            fontWeight = dueDateInfo.type.fontWeight(),
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}

@Composable
private fun DueDateType.color(): Color {
    return when (this) {
        DueDateType.EXPIRED -> MaterialTheme.colorScheme.outline
        DueDateType.TODAY -> MaterialTheme.colorScheme.error
        DueDateType.URGENT -> MaterialTheme.colorScheme.error
        DueDateType.UPCOMING -> MaterialTheme.colorScheme.onSurfaceVariant
        DueDateType.FUTURE -> MaterialTheme.colorScheme.onSurfaceVariant
    }
}

@Composable
private fun DueDateType.backgroundColor(): Color {
    return when (this) {
        DueDateType.EXPIRED -> MaterialTheme.colorScheme.surfaceVariant
        DueDateType.TODAY -> MaterialTheme.colorScheme.errorContainer
        DueDateType.URGENT -> MaterialTheme.colorScheme.errorContainer
        DueDateType.UPCOMING -> MaterialTheme.colorScheme.surfaceVariant
        DueDateType.FUTURE -> MaterialTheme.colorScheme.surfaceVariant
    }
}

@Composable
private fun DueDateType.fontWeight(): FontWeight {
    return when (this) {
        DueDateType.TODAY, DueDateType.URGENT -> FontWeight.Bold
        else -> FontWeight.Medium
    }
}

@Preview
@Composable
private fun MilitaryTypeChipPreview() {
    MilitaryTypeChip(
        text = "산업기능요원",
        containerColor = MaterialTheme.colorScheme.primaryContainer
    )
}

@Preview
@Composable
private fun MilitaryTypeChipPreview2() {
    MilitaryTypeChip(
        text = "현역",
        containerColor = MaterialTheme.colorScheme.secondaryContainer
    )
}

@Preview
@Composable
private fun DueDateTagExpiredDPreview() {
    DueDateTag(
        dueDateInfo = DueDateInfo("마감", DueDateType.EXPIRED)
    )
}

@Preview
@Composable
private fun DueDateTagTodayPreview() {
    DueDateTag(
        dueDateInfo = DueDateInfo("오늘마감", DueDateType.TODAY)
    )
}

@Preview
@Composable
private fun DueDateTagUrgentPreview() {
    DueDateTag(
        dueDateInfo = DueDateInfo("D-1", DueDateType.URGENT)
    )
}

@Preview
@Composable
private fun DueDateTagUpcomingPreview() {
    DueDateTag(
        dueDateInfo = DueDateInfo("D-6", DueDateType.UPCOMING)
    )
}

@Preview
@Composable
private fun DueDateTagFuturePreview() {
    DueDateTag(
        dueDateInfo = DueDateInfo("11/25마감", DueDateType.FUTURE)
    )
}
