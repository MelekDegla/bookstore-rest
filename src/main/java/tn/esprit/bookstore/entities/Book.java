package tn.esprit.bookstore.entities;

import org.json.JSONObject;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String isbn;

    private String title;

    private String description;

    private String imageUrl;

    private double price;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserBookRating> userBookRatings;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "book")
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Book() {
    }

    public Book(String isbn, String title, String description, String imageUrl, double price) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<UserBookRating> getUserBookRatings() {
        return userBookRatings;
    }

    public void setUserBookRatings(Set<UserBookRating> userBookRatings) {
        this.userBookRatings = userBookRatings;
    }

    @Override
    public String toString() {
        JSONObject response = new JSONObject();
        response.put("ASIN", String.valueOf(getId()));
        response.put("title", getTitle());
      //  response.put("author", getAuthor());
       // response.put("genre", getCategory());

        return response.toString();
    }


}
