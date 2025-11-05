package vamos_reciclar_maringa.AEP.dtos;

import lombok.Data;
import java.time.LocalDate;

@Data
public class AgendamentoRequestDTO {

    private String descricaoItem;
    private LocalDate dataAgendamento;
    private Integer usuarioId;
    private Integer cooperativaId;

}