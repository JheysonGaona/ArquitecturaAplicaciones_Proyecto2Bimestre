package edu.utpl.arquiapp.websocket.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cuestionarios")
public class Cuestionario implements Serializable {

    @Id
    @Column(name = "idCuestionario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuestionario;
    @Column(name = "nombreCuestionario")
    private String nombreCuestionario;
    @Column(name = "numPreguntasCuestionario")
    private int numPreguntasCuestionario;

    public Cuestionario() {

    }

    public Cuestionario(String nombreCuestionario, int numPreguntasCuestionario) {
        this.nombreCuestionario = nombreCuestionario;
        this.numPreguntasCuestionario = numPreguntasCuestionario;
    }

    public Long getIdCuestionario() {
        return idCuestionario;
    }

    public void setIdCuestionario(Long idCuestionario) {
        this.idCuestionario = idCuestionario;
    }

    public String getNombreCuestionario() {
        return nombreCuestionario;
    }

    public void setNombreCuestionario(String nombreCuestionario) {
        this.nombreCuestionario = nombreCuestionario;
    }

    public int getNumPreguntasCuestionario() {
        return numPreguntasCuestionario;
    }

    public void setNumPreguntasCuestionario(int numPreguntasCuestionario) {
        this.numPreguntasCuestionario = numPreguntasCuestionario;
    }
}

