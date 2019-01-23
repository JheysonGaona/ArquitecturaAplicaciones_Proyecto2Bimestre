package edu.utpl.arquiapp.websocket.model;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author Cristian
 */
@Entity
@Table(name="estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "idestudiantes")
    private Long codedocente;
    @Column(name = "nombre")
    private String nombre;
    // cambios
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "docentes_codedocentes")
    private List<ExamenRealizado> examenRealizados;

    public Estudiante() {
    }

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    public Estudiante(String nombre, List<ExamenRealizado> examenRealizados) {
        this.nombre = nombre;
        this.examenRealizados = examenRealizados;
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

    public List<ExamenRealizado> getExamenRealizados() {
        return examenRealizados;
    }

    public void setExamenRealizados(List<ExamenRealizado> examenRealizados) {
        this.examenRealizados = examenRealizados;
    }

}
