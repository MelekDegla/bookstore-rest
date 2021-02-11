package tn.esprit.bookstore.DTOs;

public class AddCommentDTO {

    private String text;
    private long id_user;
    private long id_book;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public long getId_book() {
        return id_book;
    }

    public void setId_book(long id_book) {
        this.id_book = id_book;
    }

    public AddCommentDTO() {
    }

    public AddCommentDTO(String text, long id_user, long id_book) {
        this.text = text;
        this.id_user = id_user;
        this.id_book = id_book;
    }
}
