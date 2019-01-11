package edu.utpl.arquiapp.websocket.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "optionmultipleoptions")
public class OptionMultipleOptions implements Serializable {

    @Id
    @Column(name = "idOptionMultipleOptions")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOptionMultipleOptions;
    @Column(name = "idOptionMultiple")
    private int idOptionMultiple;
    @Column(name = "textoOption")
    private String textoOption;
    @Column(name = "answerOption")
    private boolean answerOption;

    public OptionMultipleOptions() {

    }

    public OptionMultipleOptions(String textoOption, boolean answerOption) {
        this.textoOption = textoOption;
        this.answerOption = answerOption;
    }

    public OptionMultipleOptions(int idOptionMultiple, String textoOption, boolean answerOption) {
        this.idOptionMultiple = idOptionMultiple;
        this.textoOption = textoOption;
        this.answerOption = answerOption;
    }

    public Long getIdOptionMultipleOptions() {
        return idOptionMultipleOptions;
    }

    public void setIdOptionMultipleOptions(Long idOptionMultipleOptions) {
        this.idOptionMultipleOptions = idOptionMultipleOptions;
    }

    public int getIdOptionMultiple() {
        return idOptionMultiple;
    }

    public void setIdOptionMultiple(int idOptionMultiple) {
        this.idOptionMultiple = idOptionMultiple;
    }

    public String getTextoOption() {
        return textoOption;
    }

    public void setTextoOption(String textoOption) {
        this.textoOption = textoOption;
    }

    public boolean isAnswerOption() {
        return answerOption;
    }

    public void setAnswerOption(boolean answerOption) {
        this.answerOption = answerOption;
    }
}
