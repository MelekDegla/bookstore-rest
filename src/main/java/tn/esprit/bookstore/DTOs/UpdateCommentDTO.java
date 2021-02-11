package tn.esprit.bookstore.DTOs;

public class UpdateCommentDTO {
    private String Text;
    private long id_comment;
    private long id_user;

    public UpdateCommentDTO(String text, long id_comment, long id_user) {
        Text = text;
        this.id_comment = id_comment;
        this.id_user = id_user;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public UpdateCommentDTO() {
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public long getId_comment() {
        return id_comment;
    }

    public void setId_comment(long id_comment) {
        this.id_comment = id_comment;
    }
}
