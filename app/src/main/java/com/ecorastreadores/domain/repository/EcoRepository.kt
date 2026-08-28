package com.ecorastreadores.domain.repository

import com.ecorastreadores.domain.model.Badge
import com.ecorastreadores.domain.model.Expedition
import com.ecorastreadores.domain.model.Zone
import kotlinx.coroutines.flow.Flow

interface EcoRepository {
    fun getAllZones(): Flow<List<Zone>>
    suspend fun getZoneById(id: String): Zone?
    suspend fun updateZone(zone: Zone)
    
    fun getExpeditionsForZone(zoneId: String): Flow<List<Expedition>>
    suspend fun updateExpedition(expedition: Expedition)
    
    fun getAllBadges(): Flow<List<Badge>>
    suspend fun updateBadge(badge: Badge)
}
