package edu.utpl.arquiapp.websocket.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cuestionarios")
public class Quiz implements Serializable {

    @Id
    @Column(name = "idCuestionario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuestionario;
    @Column(name = "nombreCuestionario")
    private String nombreCuestionario;
    @Column(name = "numPreguntasCuestionario")
    private int numPreguntasCuestionario;
    @Column(name = "fechaCreacionCuestionario")
    private String fechaCreacionCuestionario;

    @ManyToOne(cascade = CascadeType.ALL)
    /*   @JoinColumn(name = "idDocente", nullable = false)
     */
    private Docente docente;

    public Quiz() {

    }

    public Quiz(String nombreCuestionario, int numPreguntasCuestionario, String fechaCreacionCuestionario) {
        this.nombreCuestionario = nombreCuestionario;
        this.numPreguntasCuestionario = numPreguntasCuestionario;
        this.fechaCreacionCuestionario = fechaCreacionCuestionario;
    }

    public Quiz(String nombreCuestionario, int numPreguntasCuestionario, String fechaCreacionCuestionario, Docente docente) {
        this.nombreCuestionario = nombreCuestionario;
        this.numPreguntasCuestionario = numPreguntasCuestionario;
        this.fechaCreacionCuestionario = fechaCreacionCuestionario;
        this.docente = docente;
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

    public String getFechaCreacionCuestionario() {
        return fechaCreacionCuestionario;
    }

    public void setFechaCreacionCuestionario(String fechaCreacionCuestionario) {
        this.fechaCreacionCuestionario = fechaCreacionCuestionario;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

}
