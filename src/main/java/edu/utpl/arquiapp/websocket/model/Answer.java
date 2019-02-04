package edu.utpl.arquiapp.websocket.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "answer")
public class Answer implements Serializable {

    @Id
    @Column(name = "idAnswer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnswer;
    private String textQuestion;
    private String textAnswer;

    public Answer() {
    }

}
