package edu.utpl.arquiapp.websocket.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "true_false")
public class QuestionTrueFalse  implements Serializable {

    @Id
    @Column(name = "idQuestionTrueFalse")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuestionTrueFalse;
    @Column(name = "textQuestion")
    private String textQuestion;
    @Column(name = "answer")
    private boolean answer;
    @ManyToOne(fetch = FetchType.LAZY)
    private Quiz quiz;

    public QuestionTrueFalse(){

    }

    public QuestionTrueFalse(String textQuestion, boolean answer, Quiz quiz) {
        this.textQuestion = textQuestion;
        this.answer = answer;
        this.quiz = quiz;
    }

    public Long getIdQuestionTrueFalse() {
        return idQuestionTrueFalse;
    }

    public void setIdQuestionTrueFalse(Long idQuestionTrueFalse) {
        this.idQuestionTrueFalse = idQuestionTrueFalse;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
