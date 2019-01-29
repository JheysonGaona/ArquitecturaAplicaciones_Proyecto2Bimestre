package edu.utpl.arquiapp.websocket.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
<<<<<<< HEAD

=======
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idQuestionOptionMultiple")
    private QuestionOptionMultiple questionOptionMultiple;
    @OneToMany
    private List<ExamenRealizado> examenRealizado;
>>>>>>> 825215dfbf0196b533b1ba18f820fedc519de628

    public OptionsQuestionOptionMultiple(){

    }

    public OptionsQuestionOptionMultiple(String textOption, boolean answer) {
        this.textOption = textOption;
        this.answer = answer;
    }

    public OptionsQuestionOptionMultiple(String textOption, boolean answer, QuestionOptionMultiple questionOptionMultiple, List<ExamenRealizado> examenRealizado) {
        this.textOption = textOption;
        this.answer = answer;
        this.questionOptionMultiple = questionOptionMultiple;
        this.examenRealizado = examenRealizado;
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

<<<<<<< HEAD
=======
    public QuestionOptionMultiple getQuestionOptionMultiple() {
        return questionOptionMultiple;
    }

    public void setQuestionOptionMultiple(QuestionOptionMultiple questionOptionMultiple) {
        this.questionOptionMultiple = questionOptionMultiple;
    }

    public List<ExamenRealizado> getExamenRealizado() {
        return examenRealizado;
    }

    public void setExamenRealizado(List<ExamenRealizado> examenRealizado) {
        this.examenRealizado = examenRealizado;
    }

>>>>>>> 825215dfbf0196b533b1ba18f820fedc519de628
}
