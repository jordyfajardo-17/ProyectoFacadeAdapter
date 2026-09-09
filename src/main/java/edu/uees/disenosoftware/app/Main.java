package edu.uees.disenosoftware.app;

import edu.uees.disenosoftware.adapter.*;
import edu.uees.disenosoftware.domain.*;
import edu.uees.disenosoftware.facade.*;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("Ana Pérez", "ana@uees.edu.ec");
        Docente docente = new Docente("Carlos López", "docente@uees.edu.ec");
        Reserva reserva = new Reserva("R-001", estudiante, docente, "Diseño de Software");

        TutoriasFacade facade = new TutoriasFacade(
                new ServicioReservas(),
                new ZoomAdapter(new ProveedorZoom()),
                new ServicioCalendario(),
                new NotificadorConsola()
        );

        facade.crearTutoriaVirtual(reserva);

        System.out.println("--- Reto Teams ---");
        Videoconferencia teams = new TeamsAdapter(new MicrosoftTeamsAPI());
        System.out.println("Enlace Teams: " + teams.crearSala(reserva.getTema(), docente.getCorreo()));
    }
}
