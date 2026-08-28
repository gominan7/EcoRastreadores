package com.ecorastreadores.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "zones")
data class ZoneEntity(
    @PrimaryKey val id: String,
    val name: String,
    val type: String, // "WATER", "AIR", "NOISE"
    val dangerLevel: Int, // 0 to 100
    val isSaved: Boolean
)
