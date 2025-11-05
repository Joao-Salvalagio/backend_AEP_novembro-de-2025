package vamos_reciclar_maringa.AEP.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cooperativa")
public class CooperativaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String telefone;

    private String tiposColetados;
}