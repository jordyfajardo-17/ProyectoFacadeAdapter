package edu.uees.disenosoftware.adapter;

public class TeamsAdapter implements Videoconferencia {
    private final MicrosoftTeamsAPI teams;

    public TeamsAdapter(MicrosoftTeamsAPI teams) {
        this.teams = teams;
    }

    @Override
    public String crearSala(String titulo, String correoDocente) {
        return teams.scheduleOnlineMeeting(titulo, correoDocente);
    }
}
