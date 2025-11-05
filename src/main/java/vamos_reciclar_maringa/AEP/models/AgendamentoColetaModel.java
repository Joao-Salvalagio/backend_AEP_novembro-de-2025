package vamos_reciclar_maringa.AEP.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
@Entity
@Table(name = "agendamentocoleta")
public class AgendamentoColetaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne //muitos para um (nossa chave estrangeira)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioModel usuario;

    @ManyToOne //muitos para um (nossa chave estrangeira)
    @JoinColumn(name = "cooperativa_id")
    private CooperativaModel cooperativa;

    private String descricaoItem;

    @Column(insertable = false, updatable = false) //o java (api) nao insere, o banco fará
    private OffsetDateTime dataSolicitacao;

    private LocalDate dataAgendamento;
    private String status;
}