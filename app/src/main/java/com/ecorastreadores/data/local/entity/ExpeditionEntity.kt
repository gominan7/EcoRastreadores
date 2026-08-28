package com.ecorastreadores.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expeditions")
data class ExpeditionEntity(
    @PrimaryKey val id: String,
    val zoneId: String,
    val title: String,
    val description: String,
    val isCompleted: Boolean,
    val orderIndex: Int
)
