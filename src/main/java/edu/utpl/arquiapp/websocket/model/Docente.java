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
    private Long codedocente;
    @Column(name = "nombre")
    String nombre;

    @OneToMany
    private List<Quiz> cuestionario;

    public Docente() {

    }

    public Docente(String nombre) {
        this.nombre = nombre;
    }

    public Long getCodedocente() {
        return codedocente;
    }

    public void setCodedocente(Long codedocente) {
        this.codedocente = codedocente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Quiz> getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(List<Quiz> cuestionario) {
        this.cuestionario = cuestionario;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "codedocente=" + codedocente +
                ", nombre='" + nombre + '\'' +
                '}';
    }

}
