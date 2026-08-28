package com.ecorastreadores.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ecorastreadores.data.local.AppDatabase
import com.ecorastreadores.data.repository.EcoRepositoryImpl
import com.ecorastreadores.domain.model.Badge
import com.ecorastreadores.domain.model.Expedition
import com.ecorastreadores.domain.model.Zone
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class EcoViewModel(application: Application) : AndroidViewModel(application) {
    private val database = AppDatabase.getDatabase(application)
    private val repository = EcoRepositoryImpl(database.appDao())

    private val _zones = MutableStateFlow<List<Zone>>(emptyList())
    val zones: StateFlow<List<Zone>> = _zones.asStateFlow()

    private val _badges = MutableStateFlow<List<Badge>>(emptyList())
    val badges: StateFlow<List<Badge>> = _badges.asStateFlow()

    private val _currentExpeditions = MutableStateFlow<List<Expedition>>(emptyList())
    val currentExpeditions: StateFlow<List<Expedition>> = _currentExpeditions.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAllZones().collectLatest {
                _zones.value = it
            }
        }
        viewModelScope.launch {
            repository.getAllBadges().collectLatest {
                _badges.value = it
            }
        }
    }

    fun loadExpeditionsForZone(zoneId: String) {
        viewModelScope.launch {
            repository.getExpeditionsForZone(zoneId).collectLatest {
                _currentExpeditions.value = it
            }
        }
    }

    fun completeExpedition(expedition: Expedition, zone: Zone) {
        viewModelScope.launch {
            // Mark expedition as completed
            repository.updateExpedition(expedition.copy(isCompleted = true))
            
            // Reduce danger level of zone
            val newDangerLevel = (zone.dangerLevel - 20).coerceAtLeast(0)
            val isSaved = newDangerLevel == 0
            repository.updateZone(zone.copy(dangerLevel = newDangerLevel, isSaved = isSaved))

            // Check if badge should be unlocked
            if (isSaved) {
                val badgeId = when (zone.id) {
                    "zone_1" -> "badge_water"
                    "zone_2" -> "badge_air"
                    "zone_3" -> "badge_noise"
                    else -> null
                }
                badgeId?.let { id ->
                    val allBadges = _badges.value
                    val badge = allBadges.find { it.id == id }
                    if (badge != null && !badge.isUnlocked) {
                        repository.updateBadge(badge.copy(isUnlocked = true))
                    }
                }
            }
        }
    }
}
