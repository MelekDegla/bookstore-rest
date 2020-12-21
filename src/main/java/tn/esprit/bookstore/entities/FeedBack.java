package tn.esprit.bookstore.entities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.time.Instant;

@Entity
public class FeedBack extends Review {

    private String name;

    private String lastname;

    private String email ;

    private String phone;

    private String subject;

    private String message;

    private Instant createdAt;

    private boolean answered;

    private String answer;

    public FeedBack(String name, String lastname, String email, String phone, String subject, String message, Instant createdAt, boolean answered, String answer) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.subject = subject;
        this.message = message;
        this.createdAt = createdAt;
        this.answered = answered;
        this.answer = answer;
    }

    public FeedBack() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
