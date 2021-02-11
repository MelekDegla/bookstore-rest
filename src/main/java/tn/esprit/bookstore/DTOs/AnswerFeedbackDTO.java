package tn.esprit.bookstore.DTOs;

public class AnswerFeedbackDTO {
    private String answer;
    private long id_feedback;

    public AnswerFeedbackDTO(String answer, long id_feedback) {
        this.answer = answer;
        this.id_feedback = id_feedback;
    }

    public AnswerFeedbackDTO() {
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public long getId_feedback() {
        return id_feedback;
    }

    public void setId_feedback(long id_feedback) {
        this.id_feedback = id_feedback;
    }
}
