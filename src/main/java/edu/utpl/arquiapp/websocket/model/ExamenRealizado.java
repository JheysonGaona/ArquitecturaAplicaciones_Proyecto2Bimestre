package edu.utpl.arquiapp.websocket.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="examenrealizados")
public class ExamenRealizado implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "codexamenrealizados")
    private int codexamenrealizados;

    @ManyToOne(fetch = FetchType.LAZY)
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    private Quiz Cuestionario;

    @ManyToOne(fetch = FetchType.LAZY)
    private OptionsQuestionOptionMultiple optionMultiple;

    @Column(name = "answerOption")
    private boolean answerOption;

    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionTrueFalse trueFalse;

    @Column(name = "answer")
    private boolean answer;

    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionShortAnswer shortAnswer;

    @Column(name = "textAnswer")
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
