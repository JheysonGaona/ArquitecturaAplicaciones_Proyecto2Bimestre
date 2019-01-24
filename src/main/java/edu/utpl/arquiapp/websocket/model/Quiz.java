package edu.utpl.arquiapp.websocket.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "quiz")
public class Quiz implements Serializable {

    @Id
    @Column(name = "idQuiz")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuiz;
    @Column(name = "nameQuiz")
    private String nameQuiz;
    @OneToMany
    private List<QuestionOptionMultiple> optionMultiple;
    @OneToMany
    private List<QuestionTrueFalse> optionTrueFalse;
    @OneToMany
    private List<QuestionShortAnswer> optionShortAnswer;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fkdocentes")
    private Docente docente;

    @OneToMany
    private List<ExamenRealizado> examenRealizado;

    public Quiz(){

    }

    public Quiz(String nameQuiz) {
        this.nameQuiz = nameQuiz;
    }

    public Quiz(String nameQuiz, Docente docente) {
        this.nameQuiz = nameQuiz;
        this.docente = docente;
    }

    public Quiz(String nameQuiz, Docente docente, List<ExamenRealizado> examenRealizado) {
        this.nameQuiz = nameQuiz;
        this.docente = docente;
        this.examenRealizado = examenRealizado;
    }

    public Long getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(Long idQuiz) {
        this.idQuiz = idQuiz;
    }

    public String getNameQuiz() {
        return nameQuiz;
    }

    public void setNameQuiz(String nameQuiz) {
        this.nameQuiz = nameQuiz;
    }

    public List<QuestionOptionMultiple> getOptionMultiple() {
        return optionMultiple;
    }

    public void setOptionMultiple(List<QuestionOptionMultiple> optionMultiple) {
        this.optionMultiple = optionMultiple;
    }

    public List<QuestionTrueFalse> getOptionTrueFalse() {
        return optionTrueFalse;
    }

    public void setOptionTrueFalse(List<QuestionTrueFalse> optionTrueFalse) {
        this.optionTrueFalse = optionTrueFalse;
    }

    public List<QuestionShortAnswer> getOptionShortAnswer() {
        return optionShortAnswer;
    }

    public void setOptionShortAnswer(List<QuestionShortAnswer> optionShortAnswer) {
        this.optionShortAnswer = optionShortAnswer;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public List<ExamenRealizado> getExamenRealizado() {
        return examenRealizado;
    }

    public void setExamenRealizado(List<ExamenRealizado> examenRealizado) {
        this.examenRealizado = examenRealizado;
    }

}
