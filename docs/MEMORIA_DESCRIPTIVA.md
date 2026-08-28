# Memoria Descriptiva - EcoRastreadores

## 1. Identificación del Proyecto
*   **Nombre:** EcoRastreadores: Analistas del Entorno.
*   **Público:** Niños de 8 a 12 años.
*   **Temática:** Ciencias Ambientales (Agua, Aire, Ruido).

## 2. Descripción General
La aplicación busca fomentar la conciencia ecológica a través de minijuegos lógicos interactivos. No se trata de un simple cuestionario; el usuario adopta el rol de un analista de campo.

## 3. Mecánicas y Game Loop
El dron "Sonda" reporta emergencias. El jugador accede a:
1. **Analizador de Agua:** Calibración de color para medir el pH (Drag & Drop en código real / Slider en UI base).
2. **Radar de Aire:** Atrapar partículas usando filtros.
3. **Osciloscopio:** Un gráfico en Jetpack Compose Canvas donde el niño iguala la amplitud y frecuencia para aislar el ruido.

El usuario gana insignias al disminuir al 0% el nivel de peligro de cada zona (Lago Cristal, Distrito Industrial, Avenida Principal).
