package edu.utpl.arquiapp.websocket.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "results")
public class Results implements Serializable {

    @Id
    @Column(name = "idResults")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResults;
    private int idQuiz;
    private String nameQuiz;
    private String student;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "results_idResults")
    private List<Answers> answers;

    public Results() {
    }

    public Results(int idQuiz, String nameQuiz, String student, List<Answers> answers) {
        this.idQuiz = idQuiz;
        this.nameQuiz = nameQuiz;
        this.student = student;
        this.answers = answers;
    }

    public Long getIdResults() {
        return idResults;
    }

    public void setIdResults(Long idResults) {
        this.idResults = idResults;
    }

    public int getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(int idQuiz) {
        this.idQuiz = idQuiz;
    }

    public String getNameQuiz() {
        return nameQuiz;
    }

    public void setNameQuiz(String nameQuiz) {
        this.nameQuiz = nameQuiz;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }
}
