package edu.utpl.arquiapp.websocket.model;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian
 */
@Entity
@Table(name="docentes")
public class Docente {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "codedocentes")
    int codedocente;
    @Column(name = "nombre")
    String nombre;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "docentes" )
    private List<Quiz> QuizList = new ArrayList<Quiz>();

    public Docente() {

    }

    public Docente(int codedocente, String nombre) {
        this.codedocente = codedocente;
        this.nombre = nombre;
    }

    public Docente(int codedocente, String nombre, List<Quiz> quizList) {
        this.codedocente = codedocente;
        this.nombre = nombre;
        QuizList = quizList;
    }

    public int getCodedocente() {
        return codedocente;
    }

    public void setCodedocente(int codedocente) {
        this.codedocente = codedocente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Quiz> getQuizList() {
        return QuizList;
    }

    public void setQuizList(List<Quiz> QuizList) {
        this.QuizList = QuizList;
    }

}
