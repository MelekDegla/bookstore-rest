package tn.esprit.bookstore.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
public class Comment extends Review {

    private String text;

    private Instant createdAt;

    private Instant updateAt;

    @ManyToOne
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }

}
