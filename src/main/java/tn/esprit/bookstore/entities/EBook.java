package tn.esprit.bookstore.entities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import java.util.List;
@Entity
public class EBook extends Book {

    private String file_url;


@OneToMany(mappedBy = "book")
private List<OrderDetails> orderDetails;
    public EBook(String isbn, String title, String description, String imageUrl, double price, String file_url) {
        super(isbn, title, description, imageUrl, price);
        this.file_url = file_url;
    }

    public EBook() {
     super();
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }
}
