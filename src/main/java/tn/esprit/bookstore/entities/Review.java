package tn.esprit.bookstore.entities;

import javax.persistence.*;
import java.util.List;

@Entity

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
