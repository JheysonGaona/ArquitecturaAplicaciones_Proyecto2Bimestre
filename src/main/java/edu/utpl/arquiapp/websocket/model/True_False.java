package edu.utpl.arquiapp.websocket.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "true_false")
public class True_False implements Serializable {

    @Id
    @Column(name = "idTrue_false")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtrue_false;
    @Column(name = "idCuestionario")
    private int idCuestionario;
    @Column(name = "textoPregunta")
    private String textoPregunta;
    @Column(name = "answer")
    private boolean answer;

    public True_False() {

    }

    public True_False(int idCuestionario, String textoPregunta, boolean answer) {
        this.idCuestionario = idCuestionario;
        this.textoPregunta = textoPregunta;
        this.answer = answer;
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

    public String getTextoPregunta() {
        return textoPregunta;
    }

    public void setTextoPregunta(String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
