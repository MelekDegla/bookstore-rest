package tn.esprit.bookstore.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

    private LocalDateTime date;

    private String place;

    private int maxParticipant;

    @ManyToMany
    @JoinTable(name = "users_events", joinColumns = {@JoinColumn(name = "event_id")}, inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> users;

    public Event(String title, String description, LocalDateTime date, String place, int maxParticipant) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.place = place;
        this.maxParticipant = maxParticipant;
    }

    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getMaxParticipant() {
        return maxParticipant;
    }

    public void setMaxParticipant(int maxParticipant) {
        this.maxParticipant = maxParticipant;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
