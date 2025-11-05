package vamos_reciclar_maringa.AEP.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pontodeentrega")
public class PontoDeEntregaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String endereco;
    private Double latitude;
    private Double longitude;

    private String horarioFunc;
    private String tiposAceitos;
}