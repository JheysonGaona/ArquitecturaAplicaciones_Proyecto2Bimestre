package edu.utpl.arquiapp.websocket.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "answers")
public class Answers implements Serializable {

    @Id
    @Column(name = "idAnswers")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnswers;
    private String question;
    private String answer;

    public Answers() {
    }

    public Answers(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Long getIdAnswers() {
        return idAnswers;
    }

    public void setIdAnswers(Long idAnswers) {
        this.idAnswers = idAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
