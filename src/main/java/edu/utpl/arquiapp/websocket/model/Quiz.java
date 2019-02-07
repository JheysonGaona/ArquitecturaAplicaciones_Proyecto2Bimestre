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
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "quiz_idQuiz")
    private List<QuestionOptionMultiple> optionMultiple;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "quiz_idQuiz")
    private List<QuestionTrueFalse> optionTrueFalse;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "quiz_idQuiz")
    private List<QuestionShortAnswer> optionShortAnswer;

    public Quiz(){
    }

    public Quiz(String nameQuiz, List<QuestionOptionMultiple> optionMultiple, List<QuestionTrueFalse> optionTrueFalse,
                List<QuestionShortAnswer> optionShortAnswer) {
        this.nameQuiz = nameQuiz;
        this.optionMultiple = optionMultiple;
        this.optionTrueFalse = optionTrueFalse;
        this.optionShortAnswer = optionShortAnswer;
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
}
