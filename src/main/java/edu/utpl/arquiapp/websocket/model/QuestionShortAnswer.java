package edu.utpl.arquiapp.websocket.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shortAnswer")
public class QuestionShortAnswer  implements Serializable {

    @Id
    @Column(name = "idQuestionShortAnswer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuestionShortAnswer;
    @Column(name = "textQuestion")
    private String textQuestion;
    @Column(name = "answer")
    private String answer;
    @ManyToOne(fetch = FetchType.LAZY)
    private Quiz quiz;

    public QuestionShortAnswer(){

    }

    public QuestionShortAnswer(String textQuestion, String answer, Quiz quiz) {
        this.textQuestion = textQuestion;
        this.answer = answer;
        this.quiz = quiz;
    }

    public Long getIdQuestionShortAnswer() {
        return idQuestionShortAnswer;
    }

    public void setIdQuestionShortAnswer(Long idQuestionShortAnswer) {
        this.idQuestionShortAnswer = idQuestionShortAnswer;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
