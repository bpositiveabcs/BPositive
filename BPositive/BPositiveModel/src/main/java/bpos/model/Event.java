package bpos.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Event extends Entity<Integer>{
    private String eventName;
    private LocalDateTime eventStartDate;
    private LocalDateTime eventEndDate;
    private Integer maxParticipants;
    private String eventDescription;
    private String eventRequirements;

    public Event(String eventName, LocalDateTime eventStartDate, LocalDateTime eventEndDate, Integer maxParticipants, String eventDescription, String eventRequirements) {
        this.eventName = eventName;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.maxParticipants = maxParticipants;
        this.eventDescription = eventDescription;
        this.eventRequirements = eventRequirements;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(LocalDateTime eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public LocalDateTime getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(LocalDateTime eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public Integer getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(Integer maxParticipants) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event event)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getEventName(), event.getEventName()) && Objects.equals(getEventStartDate(), event.getEventStartDate()) && Objects.equals(getEventEndDate(), event.getEventEndDate()) && Objects.equals(getMaxParticipants(), event.getMaxParticipants()) && Objects.equals(getEventDescription(), event.getEventDescription()) && Objects.equals(getEventRequirements(), event.getEventRequirements());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getEventName(), getEventStartDate(), getEventEndDate(), getMaxParticipants(), getEventDescription(), getEventRequirements());
    }
}
