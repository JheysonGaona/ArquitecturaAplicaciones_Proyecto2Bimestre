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
<<<<<<< HEAD
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "quiz_idQuiz")
    private List<QuestionOptionMultiple> optionMultiple;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "quiz_idQuiz")
    private List<QuestionTrueFalse> optionTrueFalse;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "quiz_idQuiz")
=======
    @OneToMany
    private List<QuestionOptionMultiple> optionMultiple;
    @OneToMany
    private List<QuestionTrueFalse> optionTrueFalse;
    @OneToMany
>>>>>>> 825215dfbf0196b533b1ba18f820fedc519de628
    private List<QuestionShortAnswer> optionShortAnswer;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fkdocentes")
    private Docente docente;

    @OneToMany
    private List<ExamenRealizado> examenRealizado;

    public Quiz(){

    }

    public Quiz(String nameQuiz, List<QuestionOptionMultiple> optionMultiple, List<QuestionTrueFalse> optionTrueFalse,
                List<QuestionShortAnswer> optionShortAnswer) {
        this.nameQuiz = nameQuiz;
        this.optionMultiple = optionMultiple;
        this.optionTrueFalse = optionTrueFalse;
        this.optionShortAnswer = optionShortAnswer;
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
