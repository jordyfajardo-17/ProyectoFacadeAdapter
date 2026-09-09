# Laboratorio Adapter + Facade

Proyecto Java/Maven del laboratorio de Diseño de Software UCOM0310, Semana 4.

## Patrones implementados
- **Adapter:** `Videoconferencia` es el Target; `ProveedorZoom` es el Adaptee; `ZoomAdapter` traduce `crearSala()` a `generarMeeting()`.
- **Facade:** `TutoriasFacade` coordina reserva, videoconferencia, calendario y notificación mediante una única operación `crearTutoriaVirtual()`.
- **Reto:** `MicrosoftTeamsAPI` + `TeamsAdapter`, sin modificar `Videoconferencia` ni `TutoriasFacade`.

## Ejecución
Requiere Java 21 y Maven.

```bash
mvn clean test
mvn clean compile
mvn exec:java -Dexec.mainClass=edu.uees.disenosoftware.app.Main
```

## UML
Los archivos `docs/adapter.puml` y `docs/facade.puml` contienen los diagramas PlantUML.
