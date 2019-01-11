package edu.utpl.arquiapp.websocket.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "optionmultiple")
public class OptionMultiple implements Serializable {

    @Id
    @Column(name = "idOptionMultiple")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOptionMultiple;
    @Column(name = "idCuestionario")
    private int idCuestionario;
    @Column(name = "textoPregunta")
    private String textoPregunta;

    public OptionMultiple() {

    }

    public OptionMultiple(int idCuestionario, String textoPregunta) {
        this.idCuestionario = idCuestionario;
        this.textoPregunta = textoPregunta;
    }

    public Long getIdOptionMultiple() {
        return idOptionMultiple;
    }

    public void setIdOptionMultiple(Long idOptionMultiple) {
        this.idOptionMultiple = idOptionMultiple;
    }

    public int getIdCuestionario() {
        return idCuestionario;
    }

    public void setIdCuestionario(int idCuestionario) {
        this.idCuestionario = idCuestionario;
    }

    public String getTextoPregunta() {
        return textoPregunta;
    }

    public void setTextoPregunta(String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }
}
