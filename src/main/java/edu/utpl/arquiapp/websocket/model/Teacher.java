package edu.utpl.arquiapp.websocket.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

    @Id
    @Column(name = "idTeacher")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTeacher;
    private String name;
    private String lastName;
    private String email;
    private String password;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "teacher_idTeacher")
    private List<Quiz> quiz;

    public Teacher() {
    }

    public Teacher(String name, String lastName, String email, String password, List<Quiz> quiz) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.quiz = quiz;
    }

    public Long getIdTeacher() {
        return idTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Quiz> getQuiz() {
        return quiz;
    }

    public void setQuiz(List<Quiz> quiz) {
        this.quiz = quiz;
    }
}
