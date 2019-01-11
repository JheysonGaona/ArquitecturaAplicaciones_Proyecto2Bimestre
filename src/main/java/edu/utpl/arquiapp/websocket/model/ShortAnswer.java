package edu.utpl.arquiapp.websocket.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shortAnswer")
public class ShortAnswer implements Serializable {

    @Id
    @Column(name = "idShortAnswer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtrue_false;
    @Column(name = "idCuestionario")
    private int idCuestionario;
    @Column(name = "textAnswer")
    private String textAnswer;

    public ShortAnswer() {

    }

    public ShortAnswer(int idCuestionario, String textAnswer) {
        this.idCuestionario = idCuestionario;
        this.textAnswer = textAnswer;
    }

    public Long getIdtrue_false() {
        return idtrue_false;
    }

    public void setIdtrue_false(Long idtrue_false) {
        this.idtrue_false = idtrue_false;
    }

    public int getIdCuestionario() {
        return idCuestionario;
    }

    public void setIdCuestionario(int idCuestionario) {
        this.idCuestionario = idCuestionario;
    }

    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }
}
