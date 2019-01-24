package edu.utpl.arquiapp.websocket.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "optionmultiple")
public class QuestionOptionMultiple implements Serializable {

    @Id
    @Column(name = "idQuestionOptionMultiple")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuestionOptionMultiple;
    @Column(name = "textQuestion")
    private String textQuestion;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idQuiz")
    private Quiz quiz;
    @OneToMany
    private List<OptionsQuestionOptionMultiple> options;

    public QuestionOptionMultiple(){

    }

    public QuestionOptionMultiple(String textQuestion, Quiz quiz) {
        this.textQuestion = textQuestion;
        this.quiz = quiz;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public QuestionOptionMultiple(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public Long getIdQuestionOptionMultiple() {
        return idQuestionOptionMultiple;
    }

    public void setIdQuestionOptionMultiple(Long idQuestionOptionMultiple) {
        this.idQuestionOptionMultiple = idQuestionOptionMultiple;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public List<OptionsQuestionOptionMultiple> getOptions() {
        return options;
    }

    public void setOptions(List<OptionsQuestionOptionMultiple> options) {
        this.options = options;
    }
}
