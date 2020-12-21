package tn.esprit.bookstore.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

    @OneToMany(mappedBy = "category")
    private List<EBook> eBooks;

    @OneToMany(mappedBy = "category")
    private List<PBook> pBooks;

    public Category(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Category() {
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
