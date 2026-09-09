package edu.uees.disenosoftware;

import edu.uees.disenosoftware.adapter.*;
import edu.uees.disenosoftware.domain.*;
import edu.uees.disenosoftware.facade.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdapterFacadeTest {

    @Test
    void zoomAdapterDebeCrearSala() {
        Videoconferencia video = new ZoomAdapter(new ProveedorZoom());
        assertEquals("https://zoom.us/meeting/123", video.crearSala("Tutoría Java", "docente@uees.edu.ec"));
    }

    @Test
    void teamsAdapterDebeCrearSala() {
        Videoconferencia video = new TeamsAdapter(new MicrosoftTeamsAPI());
        assertEquals("https://teams.microsoft.com/l/meetup-join/456", video.crearSala("Tutoría Java", "docente@uees.edu.ec"));
    }

    @Test
    void facadeDebeRetornarLaReservaGuardada() {
        Estudiante estudiante = new Estudiante("Ana", "ana@uees.edu.ec");
        Docente docente = new Docente("Carlos", "carlos@uees.edu.ec");
        Reserva reserva = new Reserva("R-001", estudiante, docente, "Programación Java");

        TutoriasFacade facade = new TutoriasFacade(
                new ServicioReservas(),
                new ZoomAdapter(new ProveedorZoom()),
                new ServicioCalendario(),
                new NotificadorConsola());

        assertSame(reserva, facade.crearTutoriaVirtual(reserva));
    }
}
