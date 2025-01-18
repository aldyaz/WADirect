package com.aldyaz.wadirect.datasource.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "history"
)
data class HistoryDb(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val countryCode: String,
    val phone: String,
    val text: String,
    val timestamp: String
)