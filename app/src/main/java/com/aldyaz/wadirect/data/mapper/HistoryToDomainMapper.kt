package com.aldyaz.wadirect.data.mapper

import com.aldyaz.wadirect.datasource.local.db.entity.HistoryDb
import com.aldyaz.wadirect.domain.model.HistoryDomainModel

class HistoryToDomainMapper : (HistoryDb) -> HistoryDomainModel {

    override fun invoke(p1: HistoryDb): HistoryDomainModel {
        return HistoryDomainModel(
            phone = p1.phone,
            timestamp = p1.timestamp
        )
    }
}