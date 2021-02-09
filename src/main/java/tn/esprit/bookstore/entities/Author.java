package tn.esprit.bookstore.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String lastname;

    private LocalDate birthdate;

    private String photoUrl;
    @OneToMany(mappedBy = "author")
    @JsonIgnoreProperties("author")

    private List<EBook> eBooks;
    @OneToMany(mappedBy = "author")
    @JsonIgnoreProperties("author")

    private List<PBook> pBooks;


    public Author(String name, String lastname, LocalDate birthdate, String photoUrl) {
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.photoUrl = photoUrl;
    }

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public List<EBook> geteBooks() {
        return eBooks;
    }

    public void seteBooks(List<EBook> eBooks) {
        this.eBooks = eBooks;
    }

    public List<PBook> getpBooks() {
        return pBooks;
    }

    public void setpBooks(List<PBook> pBooks) {
        this.pBooks = pBooks;
    }
}
