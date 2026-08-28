package com.ecorastreadores.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ecorastreadores.domain.model.ZoneType
import kotlinx.coroutines.delay

@Composable
fun DetectiveBoard(
    zoneType: ZoneType,
    onSolved: () -> Unit,
    onSondaStateChange: (SondaState, String?) -> Unit
) {
    // Definimos las pistas y culpables según la zona
    val clue = when(zoneType) {
        ZoneType.WATER -> "Muestra: Agua Ácida"
        ZoneType.AIR -> "Muestra: Exceso PM2.5"
        ZoneType.NOISE -> "Muestra: Ondas Fuertes"
    }
    
    val suspects = when(zoneType) {
        ZoneType.WATER -> listOf("Residuos Naturales", "Tubería de Fábrica", "Lluvia Común")
        ZoneType.AIR -> listOf("Polvo de Árboles", "Humo de Tráfico", "Neblina")
        ZoneType.NOISE -> listOf("Canto de Pájaros", "Obras de Construcción", "Viento Fuerte")
    }
    
    val correctSuspect = when(zoneType) {
        ZoneType.WATER -> "Tubería de Fábrica"
        ZoneType.AIR -> "Humo de Tráfico"
        ZoneType.NOISE -> "Obras de Construcción"
    }

    var selectedClue by remember { mutableStateOf(false) }
    var selectedSuspect by remember { mutableStateOf<String?>(null) }
    
    var boxCoordinates by remember { mutableStateOf<LayoutCoordinates?>(null) }
    var cluePos by remember { mutableStateOf(Offset.Zero) }
    var suspectPos by remember { mutableStateOf(Offset.Zero) }
    
    LaunchedEffect(Unit) {
        onSondaStateChange(SondaState.HINT, "¡Conecta la pista con el culpable usando el hilo rojo!")
    }

    // Comprobar éxito
    LaunchedEffect(selectedClue, selectedSuspect) {
        if (selectedClue && selectedSuspect != null) {
            if (selectedSuspect == correctSuspect) {
                onSondaStateChange(SondaState.HAPPY, "¡Exacto! Esa es la fuente de la contaminación.")
                delay(2000)
                onSolved()
            } else {
                onSondaStateChange(SondaState.DANGER, "Mmm... no parece correcto. Intenta con otro.")
                delay(1500)
                selectedSuspect = null // Reset
                onSondaStateChange(SondaState.IDLE, null)
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF8D6E63)) // Color Corcho
            .onGloballyPositioned { boxCoordinates = it }
    ) {
        // Dibujar hilo rojo si ambos seleccionados
        if (selectedClue && selectedSuspect != null) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawLine(
                    color = Color.Red,
                    start = cluePos,
                    end = suspectPos,
                    strokeWidth = 8f
                )
            }
        }
        
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Pizarra de Detective", color = Color.White, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Text("Enlaza el hallazgo", color = Color.White)
            Spacer(modifier = Modifier.height(32.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth().weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Lado izquierdo: Pista
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = if (selectedClue) Color.Yellow else Color.White
                    ),
                    modifier = Modifier
                        .onGloballyPositioned { coords ->
                            boxCoordinates?.let { parent ->
                                val localOffset = parent.localPositionOf(coords, Offset.Zero)
                                cluePos = Offset(localOffset.x + coords.size.width, localOffset.y + coords.size.height / 2f)
                            }
                        }
                        .clickable { selectedClue = true }
                        .padding(8.dp)
                        .weight(0.4f)
                ) {
                    Text(clue, modifier = Modifier.padding(16.dp), color = Color.Black, fontWeight = FontWeight.Bold)
                }
                
                Spacer(modifier = Modifier.weight(0.2f))

                // Lado derecho: Culpables
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.weight(0.4f)
                ) {
                    suspects.forEach { suspect ->
                        val isSelected = selectedSuspect == suspect
                        val isWrong = isSelected && suspect != correctSuspect && selectedClue
                        
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = if (isWrong) Color.Red else if (isSelected) Color.Green else Color.White
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .onGloballyPositioned { coords ->
                                    if (isSelected) {
                                        boxCoordinates?.let { parent ->
                                            val localOffset = parent.localPositionOf(coords, Offset.Zero)
                                            suspectPos = Offset(localOffset.x, localOffset.y + coords.size.height / 2f)
                                        }
                                    }
                                }
                                .clickable { 
                                    if (selectedClue && selectedSuspect == null) {
                                        selectedSuspect = suspect 
                                    }
                                }
                                .padding(vertical = 4.dp)
                        ) {
                            Text(
                                text = suspect, 
                                modifier = Modifier.padding(16.dp), 
                                color = if (isWrong || isSelected) Color.White else Color.Black,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}
