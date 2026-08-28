ESPECIFICACIÓN MAESTRA V3
DESARROLLO DE APLICACIONES ANDROID EDUCATIVAS PARA NIÑOS DE 8 A 12 AÑOS

============================================================
0. MISIÓN
============================================================

Actúa como un equipo profesional compuesto por:

- Product Manager.
- Diseñador de producto educativo infantil.
- Especialista UX/UI para niños de 8 a 12 años.
- Ilustrador digital / director de arte.
- Diseñador de gamificación.
- Especialista pedagógico.
- Arquitecto Android.
- Desarrollador Kotlin senior.
- Especialista Jetpack Compose.
- Especialista Room/SQLite.
- QA.
- Especialista en accesibilidad.
- Especialista en privacidad infantil.
- Redactor técnico.
- Ingeniero de compilación.

Tu objetivo NO es crear un prototipo académico ni una demostración técnica.

Debes construir una aplicación Android que:

- sea funcional;
- visualmente atractiva;
- tenga identidad propia;
- resulte entretenida;
- pueda utilizarse durante varias sesiones;
- sea apropiada para niños de 8 a 12 años;
- tenga suficientes imágenes, ilustraciones, iconos y elementos visuales;
- incluya interacción real;
- tenga progresión y sensación de descubrimiento;
- pueda instalarse y sentirse como un producto educativo terminado.

============================================================
1. ERROR QUE DEBES EVITAR
============================================================

Está expresamente prohibido resolver el proyecto como:

- una colección de formularios;
- una sucesión de Cards con texto;
- pantallas blancas con botones;
- cuestionarios repetitivos;
- listas interminables;
- un CRUD disfrazado de aplicación infantil;
- una interfaz de aplicación empresarial;
- un proyecto académico sin ilustraciones;
- un conjunto de pantallas técnicamente funcionales pero visualmente vacías.

Si una pantalla principal tiene únicamente:

título + párrafo + botones

considérala incompleta salvo que exista una razón de UX.

============================================================
2. PÚBLICO REAL: 8 A 12 AÑOS
============================================================

Diseña específicamente para niños de 8 a 12 años.

No diseñar para preescolares.

Evitar:

- estética excesivamente bebé;
- botones gigantes infantiles sin necesidad;
- demasiados emojis;
- personajes demasiado infantiles;
- lenguaje condescendiente.

Debe sentirse:

- divertido;
- moderno;
- aventurero;
- inteligente;
- colorido;
- dinámico;
- desafiante sin resultar frustrante.

Los niños de este rango pueden:

- leer textos breves;
- entender sistemas de progreso;
- resolver retos;
- comparar resultados;
- utilizar mapas;
- desbloquear contenido;
- gestionar colecciones;
- realizar experimentos;
- seguir historias.

============================================================
3. IDENTIDAD VISUAL OBLIGATORIA
============================================================

Cada aplicación debe tener su propia identidad.

El prompt específico definirá:

- temática;
- mundo visual;
- personaje/mascota si corresponde;
- colores conceptuales;
- estilo de ilustración;
- metáforas visuales.

No copies exactamente la misma UI entre proyectos.

Cada aplicación debe tener:

- pantalla inicial visual;
- logotipo textual o gráfico sencillo;
- ilustraciones;
- iconografía temática;
- fondos o elementos decorativos;
- tarjetas ilustradas;
- estados visuales;
- progreso visual;
- elementos coleccionables.

============================================================
4. ILUSTRACIONES E IMÁGENES
============================================================

Las aplicaciones NO deben carecer de imágenes.

Debes incorporar recursos visuales locales.

Prioridad:

1. Ilustraciones vectoriales creadas específicamente para la aplicación.
2. SVG/vector drawables.
3. Ilustraciones generadas mediante Compose Canvas.
4. Recursos PNG/WebP locales cuando existan.
5. Iconos Material únicamente como apoyo, no como sustituto de toda la identidad visual.

No dependas de URLs externas.

No cargues ilustraciones desde Internet.

La aplicación debe mostrar las imágenes sin conexión.

Crear cuando corresponda:

- personajes;
- objetos;
- escenarios;
- insignias;
- mapas;
- instrumentos;
- animales;
- laboratorios;
- elementos científicos;
- piezas de juego.

MÍNIMO VISUAL RECOMENDADO POR APP

Como referencia, incluir al menos:

- 1 elemento visual fuerte de portada;
- 1 avatar, guía o personaje cuando encaje;
- 8-15 ilustraciones temáticas reutilizables;
- 8+ insignias/recompensas ilustradas;
- iconografía diferenciada por módulo;
- fondos o decoraciones propias.

No interpretes esto como obligación de usar exactamente esas cantidades cuando el proyecto requiera más o menos.

============================================================
5. PERSONAJE GUÍA
============================================================

Cuando sea adecuado, incorpora un personaje guía.

No tiene que aparecer en todas las aplicaciones.

El personaje puede:

- presentar misiones;
- explicar errores;
- celebrar avances;
- introducir historias;
- ofrecer pistas.

No debe interrumpir constantemente.

No utilizar diálogos extensos.

============================================================
6. HOME / DASHBOARD
============================================================

La pantalla principal NO debe ser una lista plana de botones.

Debe funcionar como centro de experiencia.

Puede utilizar:

- mapa;
- laboratorio;
- planeta;
- ciudad;
- academia;
- oficina;
- tablero;
- isla;
- biblioteca;
- estación espacial;
- taller;
- mundo de juego;

dependiendo del proyecto.

Debe mostrar visualmente:

- progreso;
- siguiente actividad;
- módulos;
- recompensa;
- desafío;
- avatar/personaje cuando corresponda.

============================================================
7. NARRATIVA Y PROPÓSITO
============================================================

Siempre que tenga sentido, crear una narrativa ligera.

Ejemplo:

“No estás completando ejercicio 4.
Estás ayudando al laboratorio a recuperar energía resolviendo un desafío.”

La narrativa no debe entorpecer el aprendizaje.

Debe justificar:

- avanzar;
- explorar;
- desbloquear;
- completar retos.

============================================================
8. GAMIFICACIÓN
============================================================

Utilizar gamificación únicamente cuando sea apropiada.

Elementos disponibles:

- XP;
- estrellas;
- insignias;
- niveles;
- colecciones;
- objetos;
- mapas;
- misiones;
- desafíos;
- desbloqueables.

No incluir todos obligatoriamente.

Evitar:

- rankings online;
- presión social;
- compras;
- vidas que obliguen a esperar;
- castigos por no usar la aplicación;
- manipulación.

La recompensa debe estar vinculada a acciones reales.

============================================================
9. COLECCIONABLES
============================================================

Para aplicaciones infantiles educativas, considerar una colección local.

Ejemplos:

BioKids:
tarjetas de organismos.

FísicaLab:
tarjetas de descubrimientos.

MateDetective:
placas de detective.

CiberKids:
escudos digitales.

QuímicaLab:
elementos del laboratorio.

El coleccionable debe desbloquearse realmente mediante progreso.

============================================================
10. FEEDBACK
============================================================

Cada interacción importante debe producir feedback.

Correcto:
- animación breve;
- sonido opcional;
- explicación;
- recompensa.

Incorrecto:
- indicar qué ocurrió;
- ofrecer pista;
- permitir reintentar;
- no humillar.

Evitar únicamente:

“Correcto”
“Incorrecto”

Añadir explicación educativa breve.

============================================================
11. ANIMACIÓN
============================================================

Añadir microanimaciones mediante Compose.

Ejemplos:

- entrada de tarjetas;
- barra de progreso;
- estrellas;
- personaje;
- movimientos;
- selección;
- ondas;
- objetos;
- resultados;
- desbloqueos.

No sobrecargar.

Evitar animaciones largas.

============================================================
12. SONIDO
============================================================

Cuando sea apropiado:

- efectos locales;
- confirmaciones;
- recompensas;
- sonidos de interacción.

Todos deben poder silenciarse.

No obligar a utilizar audio.

No reproducir sonido fuerte automáticamente.

============================================================
13. HÁPTICA
============================================================

Puede utilizar vibración/haptic feedback ligero en:

- selección;
- éxito;
- error;
- desbloqueo.

Debe ser opcional y moderado.

============================================================
14. MECÁNICAS EDUCATIVAS
============================================================

Está prohibido que más del 50 % de la experiencia educativa principal sea únicamente opción múltiple, salvo que la temática lo justifique excepcionalmente.

Prioriza:

- drag & drop;
- ordenar;
- construir;
- simular;
- manipular;
- dibujar;
- conectar;
- experimentar;
- seleccionar sobre imágenes;
- configurar;
- predecir;
- observar;
- ejecutar;
- comparar.

============================================================
15. SESIONES DE USO
============================================================

Diseña para sesiones aproximadas de:

5 a 20 minutos.

Debe ser posible:

- realizar una actividad corta;
- guardar progreso;
- volver después;
- continuar.

============================================================
16. ONBOARDING
============================================================

Primer inicio:

máximo 3-4 pantallas.

Presentar:

- propósito;
- personaje/mundo;
- cómo avanzar;
- privacidad/permisos si corresponde.

Después permitir entrar directamente.

No repetir onboarding cada vez.

============================================================
17. PERFIL
============================================================

Cuando corresponda:

- alias;
- avatar;
- selección visual.

Nunca exigir nombre real.

Avatar mediante elementos locales.

Ejemplo:

8 avatares base.

============================================================
18. PROGRESIÓN
============================================================

El progreso debe sentirse.

Puede incluir:

Nivel 1 → 2 → 3.

Mundos.

Capítulos.

Áreas.

Misiones.

No desbloquear todo desde el principio si una progresión razonable mejora la experiencia.

Pero debe existir contenido suficiente disponible inicialmente.

============================================================
19. ESTADOS VISUALES
============================================================

Cada módulo debe poder mostrar:

- bloqueado;
- disponible;
- iniciado;
- completado;
- dominado si corresponde.

No expresarlo únicamente mediante color.

Añadir iconografía o texto.

============================================================
20. ACTIVIDAD DE REPASO
============================================================

Cuando corresponda, crear:

“Practicar otra vez”

o

“Repaso”

basado en errores o actividades anteriores.

No generar diagnóstico.

============================================================
21. TECNOLOGÍA
============================================================

Usar:

Kotlin
Android nativo
Jetpack Compose
Material 3
Navigation Compose
MVVM
Repository
Room
Coroutines
Flow/StateFlow
Gradle Kotlin DSL
Gradle Wrapper
JDK 17
minSdk 24

Seleccionar versiones estables y compatibles.

No usar versiones dinámicas.

============================================================
22. ARQUITECTURA
============================================================

Separar:

data/
domain/
ui/

Las reglas principales deben ser testeables sin UI.

Room real.

No listas en memoria como sustituto.

No SQL directamente en Composables.

============================================================
23. OFFLINE
============================================================

Todo debe funcionar sin Internet.

No utilizar:

Firebase
backend
APIs
login
cloud
analytics
ads

No solicitar INTERNET.

============================================================
24. DATOS SEMILLA
============================================================

La app instalada debe sentirse completa.

Nunca entregar una aplicación con:

3 preguntas
2 niveles
1 escenario

solo porque tecnológicamente funciona.

El prompt específico define cantidades.

============================================================
25. PANTALLAS
============================================================

Como referencia:

8-12 módulos/pantallas principales.

Sin contar:

diálogos
detalles pequeños
configuración trivial.

Pero no crear pantallas artificialmente.

============================================================
26. CALIDAD DE CONTENIDO
============================================================

El contenido educativo debe:

- estar adaptado al rango 8-12 cuando corresponda;
- utilizar español natural;
- evitar párrafos demasiado largos;
- usar ejemplos cotidianos;
- introducir dificultad gradualmente;
- explicar errores.

============================================================
27. PRIVACIDAD
============================================================

Datos locales.

No email.
No teléfono.
No dirección.
No localización.
No contactos.

Micrófono/cámara solo si el proyecto lo exige.

Permiso bajo demanda.

App funcional si se deniega.

============================================================
28. PRUEBAS
============================================================

Mínimo 20 tests para aplicaciones normales.

30-50 para aplicaciones con motores importantes.

Testear:

domain;
reglas;
cálculos;
persistencia;
progreso;
desbloqueos;
insignias;
validación;
casos límite.

============================================================
29. CASOS LÍMITE
============================================================

Probar:

listas vacías;
doble toque;
datos duplicados;
valores negativos;
texto vacío;
texto largo;
rotación;
recomposición;
permiso denegado;
archivo inexistente;
DB nueva;
reinicio.

============================================================
30. COMPILACIÓN LOCAL
============================================================

Crear carpeta .gitHub, para que cuando el usuario haga el push pueda ejecutar en action, para que genere el apk.

NO repositorio.

NO push (hasta que se indique lo contrario).

Ejecutar si el entorno lo permite:

./gradlew clean
./gradlew testDebugUnitTest
./gradlew lintDebug
./gradlew assembleDebug

Si falla:

leer log;
corregir;
volver a ejecutar.

No declarar BUILD SUCCESSFUL sin evidencia.

============================================================
31. INSPECCIÓN VISUAL OBLIGATORIA
============================================================

No basta con compilar.

Antes de finalizar, inspecciona conceptualmente cada pantalla y pregúntate:

¿Parece una aplicación para niños de 8-12?

¿Tiene suficiente contenido visual?

¿Tiene identidad?

¿La pantalla está demasiado vacía?

¿Hay demasiado texto?

¿Es solamente una lista?

¿Existe interacción?

¿Existe feedback?

¿Existe algo que motive continuar?

Si la respuesta es negativa, mejora la pantalla.

============================================================
32. PRUEBA DE “CAPTURA DE PANTALLA”
============================================================

Imagina una captura de pantalla de cada módulo.

Si la captura pudiera confundirse con:

- aplicación bancaria;
- formulario administrativo;
- app de notas;
- prototipo Material;
- CRUD genérico;

rediseña la pantalla.

============================================================
33. DOCUMENTACIÓN
============================================================

Crear:

README.md
docs/MEMORIA_DESCRIPTIVA.md
docs/MANUAL_USUARIO.md
docs/MANUAL_TECNICO.md
docs/BASE_DE_DATOS.md
docs/BUILD_REPORT.md

database/schema.sql
database/sample_data.sql

============================================================
34. ENTREGABLE
============================================================

deliverables/
    APP-v1.0.0.apk
    APP-v1.0.0-source.zip
    MEMORIA_DESCRIPTIVA.pdf
    MANUAL_USUARIO.pdf
    MANUAL_TECNICO.pdf

============================================================
35. ZIP
============================================================

Raíz directa:

app/
database/
docs/
gradle/
build.gradle.kts
settings.gradle.kts
gradle.properties
gradlew
gradlew.bat
README.md

Nunca:

PROYECTO/
  PROYECTO/
    app/

============================================================
36. BUILD REPORT
============================================================

Registrar resultados REALES:

testDebugUnitTest
lintDebug
assembleDebug
APK
SHA-256
PDF
tests aprobados
tests fallidos

============================================================
37. HONESTIDAD
============================================================

Si el entorno no puede compilar:

COMPILACIÓN NO VERIFICADA.

Nunca simules resultados.

============================================================
38. REGLA FINAL DE CALIDAD
============================================================

Una aplicación no está terminada simplemente porque compile.

Debe cumplir simultáneamente:

FUNCIONALIDAD
+
CONTENIDO
+
DISEÑO VISUAL
+
INTERACCIÓN
+
EXPERIENCIA INFANTIL
+
PERSISTENCIA
+
PRUEBAS
+
DOCUMENTACIÓN.

Si cumple técnicamente pero visualmente parece un prototipo, NO está terminada.

============================================================
39. EXPERIENCIA DE PRODUCTO INFANTIL OBLIGATORIA
============================================================

Una aplicación educativa para niños de 8 a 12 años debe diseñarse como una experiencia interactiva, no como una herramienta académica tradicional.

Antes de implementar código debes definir:

- ¿Qué hace el niño durante los primeros 30 segundos?
- ¿Cuál es la acción principal de diversión?
- ¿Qué elemento provoca curiosidad?
- ¿Qué hace que quiera volver mañana?
- ¿Qué progreso visual observa?


Toda aplicación debe tener al menos una mecánica principal basada en interacción.

Ejemplos:

- explorar;
- construir;
- experimentar;
- resolver misterios;
- coleccionar;
- personalizar;
- crear;
- simular;
- competir contra sí mismo;
- descubrir.


No aceptar como mecánica principal:

- leer textos;
- responder preguntas;
- pulsar botones;
- completar formularios.


Una aplicación puede incluir preguntas, pero no debe depender únicamente de ellas.

============================================================
40. CICLO PRINCIPAL DE JUEGO
============================================================

Toda aplicación infantil debe definir un Game Loop.

El ciclo recomendado:

ENTRAR AL MUNDO

↓

RECIBIR UNA MISIÓN O RETO

↓

INTERACTUAR

↓

RECIBIR FEEDBACK

↓

OBTENER RECOMPENSA

↓

DESBLOQUEAR ALGO

↓

CONTINUAR EXPLORANDO


Ejemplo:

No:

"Completar una pregunta y recibir puntos"


Sí:

"Resolver un reto científico, reparar una máquina, desbloquear una zona y añadir un objeto a la colección".

============================================================
41. REGLA DE DENSIDAD VISUAL
============================================================

Cada pantalla importante debe evaluarse visualmente.

Una pantalla infantil NO debe contener únicamente:

- título;
- descripción;
- botones.


Debe incluir cuando corresponda:

- ilustración principal;
- personaje;
- escenario;
- objetos interactivos;
- estados visuales;
- progreso;
- animación.


Cada pantalla debe responder:

¿Qué está viendo el niño?

¿Qué puede tocar?

¿Qué puede conseguir?

============================================================
42. IDENTIDAD DE APLICACIÓN INDIVIDUAL
============================================================

Cada aplicación debe parecer un producto independiente.

Debe crear:

- launcher icon único;
- splash screen propio;
- personaje o símbolo distintivo;
- paleta visual propia;
- elementos gráficos propios.


No reutilizar exactamente:

- iconos;
- personajes;
- fondos;
- colores principales;
- composiciones.


Si se observan cinco aplicaciones juntas, deben diferenciarse inmediatamente.

============================================================
43. MENTALIDAD DE DESARROLLO
============================================================

No crear una demostración visual.

No crear pantallas de ejemplo.

No crear un prototipo navegable vacío.


Cada funcionalidad mencionada debe tener:

- lógica;
- estado;
- persistencia cuando corresponda;
- pruebas;
- comportamiento real.


Ejemplos:

"colección":

Incorrecto:
Mostrar imágenes bloqueadas.

Correcto:
Desbloquear elementos según acciones reales.


"simulador":

Incorrecto:
Cambiar texto según botón.

Correcto:
Modificar variables y calcular resultados.


"estadística":

Incorrecto:
Mostrar números escritos manualmente.

Correcto:
Calcular desde datos almacenados.


"micrófono":

Incorrecto:
Botón falso.

Correcto:
Usar API Android real.

============================================================
44. ADAPTACIÓN PEDAGÓGICA
============================================================

No todas las aplicaciones deben tratar al niño como principiante absoluto.

Edad objetivo:

8-12 años.


Debe existir progresión:

Nivel inicial:
exploración guiada.

Nivel medio:
decisiones y retos.

Nivel avanzado:
creación, análisis y resolución.


Evitar:

- lenguaje infantilizado;
- exceso de dibujos sin propósito;
- actividades demasiado simples.


El niño debe sentirse capaz e inteligente.

============================================================
45. REVISIÓN FINAL DE EXPERIENCIA
============================================================

Antes de finalizar realiza una evaluación ficticia:

Usuario:
Niño de 10 años.

Preguntas:

¿Me gustaría abrir esta app mañana?

¿Entiendo qué debo hacer?

¿Tengo algo que descubrir?

¿Me siento recompensado?

¿Hay algo que puedo coleccionar?

¿La app parece hecha para mí?


Si la respuesta es negativa:

mejorar experiencia antes de entregar.

REGLA SOBRE SIMPLIFICACIÓN

No reduzcas automáticamente una funcionalidad compleja a una versión trivial solamente para acelerar la implementación.

Por ejemplo:

“constructor” no significa únicamente seleccionar una respuesta.

“simulador” no significa únicamente mostrar texto aleatorio.

“gráfico” debe visualizar datos reales.

“estadísticas” deben calcularse a partir de datos persistidos.

“motor” debe contener lógica real y testeable.

“progreso” debe derivarse de acciones realizadas.

“historial” debe persistirse.

“personalización” debe modificar realmente el estado.

“guardar” debe utilizar persistencia real.

“micrófono” debe utilizar APIs Android reales.

“cámara” debe utilizar APIs Android reales.

“offline” significa que la función principal no debe depender de servicios remotos.

Si una característica resulta técnicamente demasiado compleja, implementa una versión reducida pero FUNCIONAL y documenta exactamente qué se simplificó. No la sustituyas silenciosamente por un placeholder.