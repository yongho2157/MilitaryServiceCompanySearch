package com.example.militartservicecompanysearch.core.model

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime

enum class DueDateType {
    EXPIRED,      // 만료됨
    TODAY,        // 오늘 마감
    URGENT,       // 임박(3일 이내)
    UPCOMING,     // 예정(7일 이내)
    FUTURE        // 먼 미래
}

data class DueDateInfo(
    val text: String,
    val type: DueDateType
)

fun LocalDate?.calculateDueInfo(): DueDateInfo {
    if (this == null) return DueDateInfo("미정", DueDateType.FUTURE)

    val today = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    val daysUntilDue = today.daysUntil(this)

    return when {
        this < today ->
            DueDateInfo("마감", DueDateType.EXPIRED)

        daysUntilDue == 0 ->
            DueDateInfo("오늘마감", DueDateType.TODAY)

        daysUntilDue <= 3 ->
            DueDateInfo("D-$daysUntilDue", DueDateType.URGENT)

        daysUntilDue <= 7 ->
            DueDateInfo("D-$daysUntilDue", DueDateType.UPCOMING)

        else -> {
            val month = this.monthNumber
            val day = this.dayOfMonth
            DueDateInfo("~${month}/${day}", DueDateType.FUTURE)
        }
    }
}
