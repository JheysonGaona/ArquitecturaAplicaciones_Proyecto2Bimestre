package edu.utpl.arquiapp.websocket.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "true_false")
public class QuestionTrueFalse  implements Serializable {

    @Id
    @Column(name = "idQuestionTrueFalse")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuestionTrueFalse;
    @Column(name = "textQuestion")
    private String textQuestion;
    @Column(name = "answer")
    private boolean answer;
<<<<<<< HEAD

=======
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idQuiz")
    private Quiz quiz;
    @OneToMany
    private List<ExamenRealizado> examenRealizado;
>>>>>>> 825215dfbf0196b533b1ba18f820fedc519de628

    public QuestionTrueFalse(){

    }

    public QuestionTrueFalse(String textQuestion, boolean answer) {
        this.textQuestion = textQuestion;
        this.answer = answer;
    }

    public QuestionTrueFalse(String textQuestion, boolean answer, Quiz quiz, List<ExamenRealizado> examenRealizado) {
        this.textQuestion = textQuestion;
        this.answer = answer;
        this.quiz = quiz;
        this.examenRealizado = examenRealizado;
    }

    public Long getIdQuestionTrueFalse() {
        return idQuestionTrueFalse;
    }

    public void setIdQuestionTrueFalse(Long idQuestionTrueFalse) {
        this.idQuestionTrueFalse = idQuestionTrueFalse;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

<<<<<<< HEAD
=======
    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<ExamenRealizado> getExamenRealizado() {
        return examenRealizado;
    }

    public void setExamenRealizado(List<ExamenRealizado> examenRealizado) {
        this.examenRealizado = examenRealizado;
    }

>>>>>>> 825215dfbf0196b533b1ba18f820fedc519de628
}
