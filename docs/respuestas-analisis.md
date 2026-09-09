# Respuestas de análisis

## 1. ¿Qué representa Target, Adapter y Adaptee?
- **Target:** `Videoconferencia`, porque define la operación que necesita el sistema: `crearSala(String titulo, String correoDocente)`.
- **Adapter:** `ZoomAdapter`, porque implementa `Videoconferencia` y traduce la llamada al formato que entiende Zoom.
- **Adaptee:** `ProveedorZoom`, porque ya tiene su propia operación `generarMeeting(String topic, String hostEmail)`.

## 2. ¿Qué cambia si se reemplaza Zoom por Teams?
Se crea un nuevo adaptador, `TeamsAdapter`, que implementa `Videoconferencia` y utiliza `MicrosoftTeamsAPI`. El código que trabaja con `Videoconferencia`, especialmente `TutoriasFacade`, no necesita modificarse.

## 3. ¿Por qué Facade no es lo mismo que Adapter?
El **Adapter** permite que dos interfaces incompatibles puedan trabajar juntas. La **Facade** simplifica el acceso a varias clases o servicios mediante una interfaz de alto nivel. En este proyecto, `ZoomAdapter` adapta Zoom y `TutoriasFacade` coordina reserva, videoconferencia, calendario y notificación.

## 4. ¿Qué código quedaría acoplado si se elimina `Videoconferencia`?
`TutoriasFacade` tendría que depender directamente de `ProveedorZoom` o de `MicrosoftTeamsAPI`. Esto haría más difícil cambiar de proveedor y aumentaría el acoplamiento del flujo principal con una implementación concreta.

## 5. ¿Qué riesgo existe si `TutoriasFacade` empieza a validar todas las reglas de negocio?
La fachada terminaría acumulando demasiadas responsabilidades y podría convertirse en una clase difícil de mantener. Las reglas de negocio deberían estar en componentes especializados para conservar una separación clara de responsabilidades.
