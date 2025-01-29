package com.aldyaz.wadirect.data.mapper

import com.aldyaz.wadirect.datasource.local.db.entity.HistoryDb
import com.aldyaz.wadirect.domain.model.HistoryDomainModel
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.char

class HistoryToDomainMapper : (HistoryDb) -> HistoryDomainModel {

    override fun invoke(p1: HistoryDb): HistoryDomainModel {
        val timestamp = p1.timestamp
        val dateTime = DateTimeComponents.Formats.ISO_DATE_TIME_OFFSET.parse(timestamp)
        val dateTimeString = dateTime.toLocalDateTime().format(
            LocalDateTime.Format {
                dayOfMonth()
                char(' ')
                monthName(MonthNames.ENGLISH_ABBREVIATED)
                char(' ')
                year()
                char(' ')
                hour()
                char(':')
                minute()
                char(' ')
                amPmMarker(
                    am = "AM",
                    pm = "PM"
                )
            }
        )
        return HistoryDomainModel(
            phone = p1.phone,
            timestamp = dateTimeString
        )
    }
}