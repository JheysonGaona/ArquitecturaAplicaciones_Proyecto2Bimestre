package edu.utpl.arquiapp.websocket.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "optionmultipleoptions")
public class OptionsQuestionOptionMultiple implements Serializable {

    @Id
    @Column(name = "idOption")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOption;
    @Column(name = "textOption")
    private String textOption;
    @Column(name = "answer")
    private boolean answer;
    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionOptionMultiple questionOptionMultiple;

    public OptionsQuestionOptionMultiple(){

    }

    public OptionsQuestionOptionMultiple(String textOption, boolean answer, QuestionOptionMultiple questionOptionMultiple) {
        this.textOption = textOption;
        this.answer = answer;
        this.questionOptionMultiple = questionOptionMultiple;
    }

    public Long getIdOption() {
        return idOption;
    }

    public void setIdOption(Long idOption) {
        this.idOption = idOption;
    }

    public String getTextOption() {
        return textOption;
    }

    public void setTextOption(String textOption) {
        this.textOption = textOption;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public QuestionOptionMultiple getQuestionOptionMultiple() {
        return questionOptionMultiple;
    }

    public void setQuestionOptionMultiple(QuestionOptionMultiple questionOptionMultiple) {
        this.questionOptionMultiple = questionOptionMultiple;
    }
}
