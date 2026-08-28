package com.ecorastreadores.domain.model

data class Zone(
    val id: String,
    val name: String,
    val type: ZoneType,
    val dangerLevel: Int,
    val isSaved: Boolean
)

enum class ZoneType { WATER, AIR, NOISE, UNKNOWN }
