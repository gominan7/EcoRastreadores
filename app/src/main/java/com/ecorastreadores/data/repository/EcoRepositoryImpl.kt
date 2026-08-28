package com.ecorastreadores.data.repository

import com.ecorastreadores.data.local.dao.AppDao
import com.ecorastreadores.data.local.entity.BadgeEntity
import com.ecorastreadores.data.local.entity.ExpeditionEntity
import com.ecorastreadores.data.local.entity.ZoneEntity
import com.ecorastreadores.domain.model.Badge
import com.ecorastreadores.domain.model.Expedition
import com.ecorastreadores.domain.model.Zone
import com.ecorastreadores.domain.model.ZoneType
import com.ecorastreadores.domain.repository.EcoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class EcoRepositoryImpl(
    private val dao: AppDao
) : EcoRepository {

    override fun getAllZones(): Flow<List<Zone>> {
        return dao.getAllZones().map { list -> list.map { it.toDomain() } }
    }

    override suspend fun getZoneById(id: String): Zone? {
        return dao.getZoneById(id)?.toDomain()
    }

    override suspend fun updateZone(zone: Zone) {
        dao.updateZone(zone.toEntity())
    }

    override fun getExpeditionsForZone(zoneId: String): Flow<List<Expedition>> {
        return dao.getExpeditionsForZone(zoneId).map { list -> list.map { it.toDomain() } }
    }

    override suspend fun updateExpedition(expedition: Expedition) {
        dao.updateExpedition(expedition.toEntity())
    }

    override fun getAllBadges(): Flow<List<Badge>> {
        return dao.getAllBadges().map { list -> list.map { it.toDomain() } }
    }

    override suspend fun updateBadge(badge: Badge) {
        dao.updateBadge(badge.toEntity())
    }
}

// Mappers
fun ZoneEntity.toDomain() = Zone(
    id = id,
    name = name,
    type = try { ZoneType.valueOf(type) } catch(e: Exception) { ZoneType.UNKNOWN },
    dangerLevel = dangerLevel,
    isSaved = isSaved
)

fun Zone.toEntity() = ZoneEntity(
    id = id,
    name = name,
    type = type.name,
    dangerLevel = dangerLevel,
    isSaved = isSaved
)

fun ExpeditionEntity.toDomain() = Expedition(
    id = id,
    zoneId = zoneId,
    title = title,
    description = description,
    isCompleted = isCompleted,
    orderIndex = orderIndex
)

fun Expedition.toEntity() = ExpeditionEntity(
    id = id,
    zoneId = zoneId,
    title = title,
    description = description,
    isCompleted = isCompleted,
    orderIndex = orderIndex
)

fun BadgeEntity.toDomain() = Badge(
    id = id,
    name = name,
    description = description,
    isUnlocked = isUnlocked,
    iconName = iconName
)

fun Badge.toEntity() = BadgeEntity(
    id = id,
    name = name,
    description = description,
    isUnlocked = isUnlocked,
    iconName = iconName
)
