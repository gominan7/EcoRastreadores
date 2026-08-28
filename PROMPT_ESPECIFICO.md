# PROMPT ESPECÍFICO: EcoRastreadores

**INSTRUCCIÓN PARA LA IA:**
Actúa como el equipo profesional de desarrollo descrito en el documento **MASTER_SPEC**. Tu objetivo es desarrollar la siguiente aplicación educativa específica cumpliendo rigurosamente todas las reglas de diseño infantil, interacción, offline y arquitectura técnica.

---

## 1. DEFINICIÓN DEL PROYECTO
*   **Nombre de la App:** EcoRastreadores: Analistas del Entorno
*   **Área Educativa:** Monitoreo Ambiental (Interpretación de datos de aire, agua y ruido).
*   **Público Objetivo:** Niños de 8 a 12 años. *El tono debe ser de investigación tecnológica y detectivesca, no un registro aburrido de datos estadísticos.*
*   **Descripción:** Una estación de monitoreo portátil donde los niños recolectan muestras virtuales, analizan gráficos interactivos y toman decisiones para salvar diferentes zonas afectadas por la contaminación.

## 2. IDENTIDAD VISUAL Y TEMÁTICA
*   **Mundo Visual:** Una interfaz futurista y ecológica, similar a la tableta de un científico de campo. Predominan colores verde neón, cian, blanco y fondos oscuros (modo radar).
*   **Personaje Guía:** "Sonda", un pequeño dron explorador con diferentes lentes y micrófonos que ayuda a recolectar las muestras ambientales.
*   **Coleccionables Locales:** 
    *   *Insignias de Analista*: Desbloqueables por dominar el uso de diferentes sensores (ej. Experto en Acústica, Guardián del Agua).
    *   *Reportes de Misión*: Tarjetas guardadas en la bitácora que resumen los hallazgos de cada zona salvada.

## 3. MECÁNICAS EDUCATIVAS (Interacción obligatoria)
*Prohibido crear solo un listado de datos o cuestionarios de selección múltiple.*
*   **Analizador de Calidad del Agua (Simulador de pH y Turbidez):** El niño sumerge tiras reactivas (Drag & Drop) en muestras de agua. Usando Canvas de Compose, debe mover un deslizador para hacer coincidir el color de la tira con la escala de pH y descubrir si el agua es ácida o segura.
*   **Radar de Calidad del Aire (Caza-partículas):** Una mecánica de interceptación donde se visualizan partículas flotantes (PM2.5, PM10). El niño debe arrastrar el filtro correcto al centro de la pantalla para atrapar el tipo de contaminante adecuado antes de que acabe el tiempo.
*   **Osciloscopio de Ruido (Ondas Sonoras):** Un gráfico de ondas animado. El niño utiliza controles deslizantes de "frecuencia" y "amplitud" para que la onda de su dispositivo coincida con la del ruido molesto (ej. tráfico pesado), logrando así aislar el sonido e identificar la fuente.

## 4. GAME LOOP (Ciclo Principal de Juego)
1.  **Alerta Ambiental:** Sonda el dron envía una notificación de anomalía en el mapa principal.
2.  **Recolección:** Despliegue en la zona (Bosque, Centro de la Ciudad, Lago).
3.  **Análisis Interactivo:** Uso del Analizador de Agua, Radar de Aire u Osciloscopio según la emergencia.
4.  **Interpretación:** Basado en el resultado visual, el niño elige qué acción tomar (ej. "El agua está muy ácida, contactemos a la fábrica").
5.  **Recompensa:** La zona recupera sus niveles normales en el mapa. El jugador recibe una Insignia de Analista y un Reporte de Misión para su bitácora.

## 5. ESTRUCTURA DE PANTALLAS PRINCIPALES (UI/UX)
1.  **Splash Screen:** Una onda de radar escaneando el logotipo de la aplicación.
2.  **Centro de Comando (Dashboard):** Un mapa topográfico interactivo con marcadores de emergencia y un panel lateral con acceso rápido a las herramientas.
3.  **Laboratorio Portátil (Módulo Interactivo):** La interfaz donde se operan los sensores de Agua, Aire y Ruido, utilizando microanimaciones, sliders y gráficos en tiempo real con Canvas.
4.  **Bitácora de Campo (Colección):** Perfil del analista con sus estadísticas, insignias logradas y conceptos ambientales aprendidos.

## 6. DATOS SEMILLA (Room Database Obligatorio)
*   **3 Zonas de Monitoreo:**
    1.  *El Lago Cristal* (Emergencias de calidad del agua).
    2.  *Distrito Industrial* (Emergencias de calidad del aire).
    3.  *Avenida Principal* (Emergencias de contaminación acústica).
*   Mínimo **15 expediciones/casos** precargados.
*   Gestión de progreso, niveles de contaminación de cada zona e inventario de insignias totalmente persistidos mediante SQLite/Room.

## 7. REQUISITOS TÉCNICOS EXIGIDOS
*   **Tecnología:** Android nativo, Kotlin, Jetpack Compose, Material 3.
*   **Diseño Interactivo:** Alto uso de Canvas para dibujar las ondas sonoras, simulaciones de partículas en el aire y transiciones de color para las pruebas de pH.
*   **Arquitectura:** MVVM, Clean Architecture. Uso de Coroutines y StateFlow para manejar el estado dinámico de los simuladores.
*   **Offline:** 100% funcional sin conexión a Internet.
*   **Pruebas:** Mínimo 20 tests unitarios verificando la persistencia de Room y la lógica de validación de los sensores (ej. que la coincidencia de ondas sea matemáticamente correcta).
*   **Documentables:** Crear `README.md`, `docs/MEMORIA_DESCRIPTIVA.md`, `docs/MANUAL_USUARIO.md` y `docs/MANUAL_TECNICO.md`.