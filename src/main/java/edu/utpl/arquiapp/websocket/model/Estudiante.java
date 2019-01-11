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
@Table(name="estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "idestudiantes")
    int codedocente;
    @Column(name = "nombre")
    String nombre;

    public Estudiante(int codedocente, String nombre) {
        this.codedocente = codedocente;
        this.nombre = nombre;
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

}
