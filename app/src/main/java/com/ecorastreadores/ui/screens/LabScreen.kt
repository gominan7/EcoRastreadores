package com.ecorastreadores.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.ecorastreadores.domain.model.Zone
import com.ecorastreadores.domain.model.ZoneType
import com.ecorastreadores.ui.viewmodel.EcoViewModel
import kotlin.math.sin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabScreen(
    zoneId: String,
    viewModel: EcoViewModel,
    onBack: () -> Unit
) {
    val zones by viewModel.zones.collectAsState()
    val zone = zones.find { it.id == zoneId }

    LaunchedEffect(zoneId) {
        viewModel.loadExpeditionsForZone(zoneId)
    }

    val expeditions by viewModel.currentExpeditions.collectAsState()
    val currentExpedition = expeditions.firstOrNull { !it.isCompleted }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Laboratorio: ${zone?.name ?: ""}") },
                navigationIcon = {
                    Button(onClick = onBack) { Text("<") }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (zone == null) {
                Text("Zona no encontrada")
                return@Scaffold
            }

            if (zone.isSaved) {
                Text(
                    "¡Esta zona está a salvo! Contaminación: 0%",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleLarge
                )
            } else if (currentExpedition != null) {
                Text(
                    text = "Misión: ${currentExpedition.title}",
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = currentExpedition.description,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(32.dp))

                // Interactive module based on Zone Type
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .background(MaterialTheme.colorScheme.surface, shape = MaterialTheme.shapes.medium)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    when (zone.type) {
                        ZoneType.WATER -> WaterLabSimulator(onSuccess = { viewModel.completeExpedition(currentExpedition, zone) })
                        ZoneType.AIR -> AirLabSimulator(onSuccess = { viewModel.completeExpedition(currentExpedition, zone) })
                        ZoneType.NOISE -> NoiseLabSimulator(onSuccess = { viewModel.completeExpedition(currentExpedition, zone) })
                        else -> Text("Módulo desconocido")
                    }
                }
            } else {
                Text("Todas las misiones completadas aquí.")
            }
        }
    }
}

@Composable
fun WaterLabSimulator(onSuccess: () -> Unit) {
    var phValue by remember { mutableFloatStateOf(0f) }
    val targetPh = 7f // Neutral pH

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Calibra la tira reactiva de pH a nivel neutro (7.0)", color = Color.White)
        Spacer(modifier = Modifier.height(16.dp))
        
        // Simulación visual del color del pH
        val phColor = when {
            phValue < 4 -> Color.Red
            phValue > 10 -> Color.Blue
            phValue in 6.5f..7.5f -> Color.Green
            else -> Color.Yellow
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(phColor)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        Text("Nivel actual: ${"%.1f".format(phValue)}", color = Color.White)
        Slider(
            value = phValue,
            onValueChange = { phValue = it },
            valueRange = 0f..14f,
            modifier = Modifier.padding(horizontal = 32.dp)
        )
        
        Button(
            onClick = onSuccess,
            enabled = phValue in 6.5f..7.5f,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Estabilizar Muestra")
        }
    }
}

@Composable
fun AirLabSimulator(onSuccess: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Filtra las partículas PM2.5 (Toca el botón cuando esté verde)", color = Color.White)
        Spacer(modifier = Modifier.height(16.dp))
        
        val infiniteTransition = rememberInfiniteTransition(label = "air")
        val alpha by infiniteTransition.animateFloat(
            initialValue = 0.2f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(1000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = "alpha"
        )
        
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(MaterialTheme.colorScheme.primary.copy(alpha = alpha), shape = MaterialTheme.shapes.extraLarge)
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onSuccess) {
            Text("Activar Filtro")
        }
    }
}

@Composable
fun NoiseLabSimulator(onSuccess: () -> Unit) {
    var amplitude by remember { mutableFloatStateOf(50f) }
    var frequency by remember { mutableFloatStateOf(1f) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Sincroniza la onda para cancelar el ruido", color = Color.White)
        Spacer(modifier = Modifier.height(16.dp))
        
        val phase = rememberInfiniteTransition(label = "phase").animateFloat(
            initialValue = 0f,
            targetValue = 2f * Math.PI.toFloat(),
            animationSpec = infiniteRepeatable(tween(2000, easing = LinearEasing)),
            label = "phase_anim"
        )

        Canvas(modifier = Modifier.fillMaxWidth().height(150.dp)) {
            val path = Path()
            val centerY = size.height / 2
            
            for (x in 0 until size.width.toInt()) {
                val y = centerY + sin((x * 0.05f * frequency) + phase.value) * amplitude
                if (x == 0) path.moveTo(x.toFloat(), y)
                else path.lineTo(x.toFloat(), y)
            }
            drawPath(path, Color.Cyan, style = Stroke(width = 5f))
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("Amplitud", color = Color.White)
        Slider(value = amplitude, onValueChange = { amplitude = it }, valueRange = 10f..100f)
        
        Text("Frecuencia", color = Color.White)
        Slider(value = frequency, onValueChange = { frequency = it }, valueRange = 0.5f..3f)

        Button(
            onClick = onSuccess,
            enabled = amplitude < 30f && frequency > 2f,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Aislar Ruido")
        }
    }
}
