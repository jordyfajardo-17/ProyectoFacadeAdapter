package edu.uees.disenosoftware.adapter;

public class MicrosoftTeamsAPI {
    public String scheduleOnlineMeeting(String subject, String organizer) {
        System.out.println("Teams crea reunión: " + subject + " para " + organizer);
        return "https://teams.microsoft.com/l/meeting/123";
    }
}
