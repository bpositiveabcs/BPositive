package bpos.networking.dto;

import bpos.model.Center;

import java.time.LocalDateTime;

public class EventDTO implements java.io.Serializable{
    private String eventName;
    private String eventAnnouncementDate;
    private String eventStartDate;
    private String eventEndDate;
    private String maxParticipants;
    private String eventDescription;
    private String eventRequirements;
    private CenterDTO center;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventAnnouncementDate() {
        return eventAnnouncementDate;
    }

    public void setEventAnnouncementDate(String eventAnnouncementDate) {
        this.eventAnnouncementDate = eventAnnouncementDate;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public String getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public String getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(String maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventRequirements() {
        return eventRequirements;
    }

    public void setEventRequirements(String eventRequirements) {
        this.eventRequirements = eventRequirements;
    }

    public CenterDTO getCenter() {
        return center;
    }

    public void setCenter(CenterDTO center) {
        this.center = center;
    }

    public EventDTO(String eventName, String eventAnnouncementDate, String eventStartDate, String eventEndDate, String maxParticipants, String eventDescription, String eventRequirements, CenterDTO center) {
        this.eventName = eventName;
        this.eventAnnouncementDate = eventAnnouncementDate;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.maxParticipants = maxParticipants;
        this.eventDescription = eventDescription;
        this.eventRequirements = eventRequirements;
        this.center = center;
    }
}
