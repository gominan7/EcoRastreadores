package com.ecorastreadores.domain.model

data class Expedition(
    val id: String,
    val zoneId: String,
    val title: String,
    val description: String,
    val isCompleted: Boolean,
    val orderIndex: Int
)
