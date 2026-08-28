package com.ecorastreadores

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class SensorValidationTest {

    // Water Sensor Tests
    @Test
    fun testWaterPhValidation_isNeutral_ReturnsTrue() {
        val phValue = 7.0f
        val isValid = phValue in 6.5f..7.5f
        assertTrue(isValid)
    }

    @Test
    fun testWaterPhValidation_isAcidic_ReturnsFalse() {
        val phValue = 3.5f
        val isValid = phValue in 6.5f..7.5f
        assertFalse(isValid)
    }

    @Test
    fun testWaterPhValidation_isBasic_ReturnsFalse() {
        val phValue = 10.0f
        val isValid = phValue in 6.5f..7.5f
        assertFalse(isValid)
    }

    // Noise Sensor Tests
    @Test
    fun testNoiseValidation_correctAmplitudeAndFrequency_ReturnsTrue() {
        val amplitude = 25f
        val frequency = 2.5f
        val isValid = amplitude < 30f && frequency > 2f
        assertTrue(isValid)
    }

    @Test
    fun testNoiseValidation_wrongAmplitude_ReturnsFalse() {
        val amplitude = 50f
        val frequency = 2.5f
        val isValid = amplitude < 30f && frequency > 2f
        assertFalse(isValid)
    }

    @Test
    fun testNoiseValidation_wrongFrequency_ReturnsFalse() {
        val amplitude = 20f
        val frequency = 1.0f
        val isValid = amplitude < 30f && frequency > 2f
        assertFalse(isValid)
    }

    // Zone Logic Tests
    @Test
    fun testZoneDangerReduction() {
        val initialDanger = 50
        val newDangerLevel = (initialDanger - 20).coerceAtLeast(0)
        assertTrue(newDangerLevel == 30)
    }

    @Test
    fun testZoneDangerReduction_doesNotGoBelowZero() {
        val initialDanger = 10
        val newDangerLevel = (initialDanger - 20).coerceAtLeast(0)
        assertTrue(newDangerLevel == 0)
    }
}
