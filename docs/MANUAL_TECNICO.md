# Manual Técnico - EcoRastreadores

## Arquitectura
La aplicación está construida usando **Clean Architecture** y **MVVM**:
- **Capa Data:** `Room Database` maneja la persistencia offline de las Zonas, Expediciones e Insignias.
- **Capa Domain:** Modelos puros en Kotlin (`Zone`, `Expedition`, `Badge`) y la interfaz `EcoRepository`.
- **Capa UI:** `Jetpack Compose` con `Material 3` y `Navigation Compose`. Los estados son gestionados por `EcoViewModel` mediante `StateFlow`.

## Tecnologías Utilizadas
- **Kotlin & Jetpack Compose:** UI declarativa y Canvas (`LabScreen`).
- **Coroutines & Flow:** Para operaciones asíncronas y programación reactiva de estado.
- **Room SQLite:** Base de datos. Los datos iniciales ("Semilla") se cargan usando un `RoomDatabase.Callback`.
- **GitHub Actions:** CI configurado en `.github/workflows/build.yml` para compilar el APK.
