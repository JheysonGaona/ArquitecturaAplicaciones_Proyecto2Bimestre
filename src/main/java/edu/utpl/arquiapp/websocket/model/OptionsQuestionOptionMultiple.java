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


    public OptionsQuestionOptionMultiple(){

    }

    public OptionsQuestionOptionMultiple(String textOption, boolean answer) {
        this.textOption = textOption;
        this.answer = answer;
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
}
