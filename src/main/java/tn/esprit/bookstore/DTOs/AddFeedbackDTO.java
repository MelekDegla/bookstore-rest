package tn.esprit.bookstore.DTOs;

public class AddFeedbackDTO {
    private String name;

    private String lastname;

    private String email ;

    private String phone;

    private String subject;

    private String message;

    private long id_user;

    public AddFeedbackDTO(String name, String lastname, String email, String phone, String subject, String message, long id_user) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.subject = subject;
        this.message = message;
        this.id_user = id_user;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public AddFeedbackDTO() {
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
}
