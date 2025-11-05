package vamos_reciclar_maringa.AEP.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "calendario_coleta")
public class CalendarioColetaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String bairro;

    private String tipoColeta;

    private String diasSemana;

    private String horario;
}