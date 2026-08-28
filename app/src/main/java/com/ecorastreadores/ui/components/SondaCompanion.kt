package com.ecorastreadores.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

enum class SondaState {
    IDLE,
    HAPPY,
    DANGER,
    HINT
}

@Composable
fun SondaCompanion(
    state: SondaState,
    modifier: Modifier = Modifier,
    message: String? = null
) {
    // Definir colores según el estado
    val targetColor = when (state) {
        SondaState.IDLE -> Color(0xFF00E5FF) // Cyan
        SondaState.HAPPY -> Color(0xFF00E676) // Green
        SondaState.DANGER -> Color(0xFFFF1744) // Red
        SondaState.HINT -> Color(0xFFFFEA00) // Yellow
    }

    val animatedColor by animateColorAsState(
        targetValue = targetColor,
        animationSpec = tween(durationMillis = 500),
        label = "sonda_color"
    )

    // Animación de flotación (IDLE, HINT) o salto (HAPPY) o vibración (DANGER)
    val infiniteTransition = rememberInfiniteTransition(label = "sonda_motion")
    
    val floatOffset by infiniteTransition.animateFloat(
        initialValue = if (state == SondaState.DANGER) -5f else -10f,
        targetValue = if (state == SondaState.DANGER) 5f else 10f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = when (state) {
                    SondaState.HAPPY -> 300
                    SondaState.DANGER -> 100
                    else -> 1000
                },
                easing = if (state == SondaState.HAPPY) FastOutSlowInEasing else LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "sonda_float"
    )

    // Animación para el ojo de Sonda (parpadeo)
    val eyeScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = if (state == SondaState.HAPPY) 0.1f else 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 200, delayMillis = 2000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "sonda_eye"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        // Mensaje de pista (Hint)
        if (message != null && (state == SondaState.HINT || state == SondaState.DANGER || state == SondaState.HAPPY)) {
            Text(
                text = message,
                color = animatedColor,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        // Dibujar a Sonda con Canvas
        Canvas(
            modifier = Modifier
                .size(80.dp)
                .offset(
                    x = if (state == SondaState.DANGER) floatOffset.dp else 0.dp,
                    y = if (state != SondaState.DANGER) floatOffset.dp else 0.dp
                )
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            val centerX = canvasWidth / 2
            val centerY = canvasHeight / 2

            // Cuerpo principal (Dron)
            drawRoundRect(
                color = Color.DarkGray,
                topLeft = Offset(centerX - 30f, centerY - 20f),
                size = Size(60f, 40f),
                cornerRadius = CornerRadius(15f, 15f)
            )

            // Antenas / Hélices
            drawLine(
                color = Color.LightGray,
                start = Offset(centerX - 20f, centerY - 20f),
                end = Offset(centerX - 30f, centerY - 40f),
                strokeWidth = 4f
            )
            drawLine(
                color = Color.LightGray,
                start = Offset(centerX + 20f, centerY - 20f),
                end = Offset(centerX + 30f, centerY - 40f),
                strokeWidth = 4f
            )
            
            // Círculos de hélices
            drawCircle(
                color = animatedColor.copy(alpha = 0.5f),
                radius = 10f,
                center = Offset(centerX - 30f, centerY - 40f)
            )
            drawCircle(
                color = animatedColor.copy(alpha = 0.5f),
                radius = 10f,
                center = Offset(centerX + 30f, centerY - 40f)
            )

            // Ojo central (Lente de cámara)
            drawCircle(
                color = Color.Black,
                radius = 15f,
                center = Offset(centerX, centerY)
            )
            
            // Brillo del ojo (animado)
            drawOval(
                color = animatedColor,
                topLeft = Offset(centerX - 10f, centerY - 10f * eyeScale),
                size = Size(20f, 20f * eyeScale)
            )
        }
    }
}
