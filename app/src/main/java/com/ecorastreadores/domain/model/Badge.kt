package com.ecorastreadores.domain.model

data class Badge(
    val id: String,
    val name: String,
    val description: String,
    val isUnlocked: Boolean,
    val iconName: String
)
