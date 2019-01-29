package edu.utpl.arquiapp.websocket.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="examenrealizados")
public class ExamenRealizado implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "idexamen")
    private int codexamenrealizados;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fkestudiante")
    private Estudiante estudiante;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fkquiz")
    private Quiz Cuestionario;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fkopciones")
    private OptionsQuestionOptionMultiple optionMultiple;

    @Column(name = "opcion")
    private boolean answerOption;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fktrue_false")
    private QuestionTrueFalse trueFalse;

    @Column(name = "truefalse")
    private boolean answer;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fkshortanswer")
    private QuestionShortAnswer shortAnswer;

    @Column(name = "answer")
    private String textAnswer;

    public ExamenRealizado() {
    }

    public ExamenRealizado(Estudiante estudiante, Quiz cuestionario, OptionsQuestionOptionMultiple optionMultiple, boolean answerOption, QuestionTrueFalse trueFalse, boolean answer, QuestionShortAnswer shortAnswer, String textAnswer) {
        this.estudiante = estudiante;
        Cuestionario = cuestionario;
        this.optionMultiple = optionMultiple;
        this.answerOption = answerOption;
        this.trueFalse = trueFalse;
        this.answer = answer;
        this.shortAnswer = shortAnswer;
        this.textAnswer = textAnswer;
    }

    public int getCodexamenrealizados() {
        return codexamenrealizados;
    }

    public void setCodexamenrealizados(int codexamenrealizados) {
        this.codexamenrealizados = codexamenrealizados;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Quiz getCuestionario() {
        return Cuestionario;
    }

    public void setCuestionario(Quiz cuestionario) {
        Cuestionario = cuestionario;
    }

    public OptionsQuestionOptionMultiple getOptionMultiple() {
        return optionMultiple;
    }

    public void setOptionMultiple(OptionsQuestionOptionMultiple optionMultiple) {
        this.optionMultiple = optionMultiple;
    }

    public boolean isAnswerOption() {
        return answerOption;
    }

    public void setAnswerOption(boolean answerOption) {
        this.answerOption = answerOption;
    }

    public QuestionTrueFalse getTrueFalse() {
        return trueFalse;
    }

    public void setTrueFalse(QuestionTrueFalse trueFalse) {
        this.trueFalse = trueFalse;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public QuestionShortAnswer getShortAnswer() {
        return shortAnswer;
    }

    public void setShortAnswer(QuestionShortAnswer shortAnswer) {
        this.shortAnswer = shortAnswer;
    }

    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }

}
