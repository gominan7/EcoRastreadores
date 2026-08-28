package com.ecorastreadores.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ecorastreadores.data.local.dao.AppDao
import com.ecorastreadores.data.local.entity.BadgeEntity
import com.ecorastreadores.data.local.entity.ExpeditionEntity
import com.ecorastreadores.data.local.entity.ZoneEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [ZoneEntity::class, ExpeditionEntity::class, BadgeEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "ecorastreadores_database"
                )
                .addCallback(AppDatabaseCallback())
                .build()
                INSTANCE = instance
                instance
            }
        }
    }

    private class AppDatabaseCallback : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                CoroutineScope(Dispatchers.IO).launch {
                    populateDatabase(database.appDao())
                }
            }
        }

        suspend fun populateDatabase(dao: AppDao) {
            // Seed Zones
            val zones = listOf(
                ZoneEntity("zone_1", "El Lago Cristal", "WATER", 85, false),
                ZoneEntity("zone_2", "Distrito Industrial", "AIR", 90, false),
                ZoneEntity("zone_3", "Avenida Principal", "NOISE", 75, false)
            )
            dao.insertZones(zones)

            // Seed Expeditions (15 total, 5 per zone)
            val expeditions = mutableListOf<ExpeditionEntity>()
            // Lago Cristal
            for (i in 1..5) {
                expeditions.add(ExpeditionEntity("exp_1_$i", "zone_1", "Análisis de Turbidez $i", "Mide los niveles de pH y turbidez del agua.", false, i))
            }
            // Distrito Industrial
            for (i in 1..5) {
                expeditions.add(ExpeditionEntity("exp_2_$i", "zone_2", "Filtro de Partículas $i", "Atrapa las partículas PM2.5 y PM10 en el aire.", false, i))
            }
            // Avenida Principal
            for (i in 1..5) {
                expeditions.add(ExpeditionEntity("exp_3_$i", "zone_3", "Sincronización Acústica $i", "Aísla el ruido molesto con el osciloscopio.", false, i))
            }
            dao.insertExpeditions(expeditions)

            // Seed Badges
            val badges = listOf(
                BadgeEntity("badge_water", "Guardián del Agua", "Dominaste el analizador de pH.", false, "ic_badge_water"),
                BadgeEntity("badge_air", "Protector del Aire", "Interceptaste contaminantes del aire.", false, "ic_badge_air"),
                BadgeEntity("badge_noise", "Experto en Acústica", "Aislaste frecuencias complejas de ruido.", false, "ic_badge_noise")
            )
            dao.insertBadges(badges)
        }
    }
}
