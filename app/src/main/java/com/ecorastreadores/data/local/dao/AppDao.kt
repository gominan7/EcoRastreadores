package com.ecorastreadores.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ecorastreadores.data.local.entity.BadgeEntity
import com.ecorastreadores.data.local.entity.ExpeditionEntity
import com.ecorastreadores.data.local.entity.ZoneEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {
    @Query("SELECT * FROM zones")
    fun getAllZones(): Flow<List<ZoneEntity>>

    @Query("SELECT * FROM zones WHERE id = :id")
    suspend fun getZoneById(id: String): ZoneEntity?

    @Update
    suspend fun updateZone(zone: ZoneEntity)

    @Query("SELECT * FROM expeditions WHERE zoneId = :zoneId ORDER BY orderIndex ASC")
    fun getExpeditionsForZone(zoneId: String): Flow<List<ExpeditionEntity>>

    @Update
    suspend fun updateExpedition(expedition: ExpeditionEntity)

    @Query("SELECT * FROM badges")
    fun getAllBadges(): Flow<List<BadgeEntity>>

    @Update
    suspend fun updateBadge(badge: BadgeEntity)

    // Used for seeding
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertZones(zones: List<ZoneEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExpeditions(expeditions: List<ExpeditionEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBadges(badges: List<BadgeEntity>)
}
