package vamos_reciclar_maringa.AEP.services;

import vamos_reciclar_maringa.AEP.dtos.AgendamentoRequestDTO;
import vamos_reciclar_maringa.AEP.models.AgendamentoColetaModel;
import vamos_reciclar_maringa.AEP.models.CooperativaModel;
import vamos_reciclar_maringa.AEP.models.UsuarioModel;
import vamos_reciclar_maringa.AEP.repositories.AgendamentoColetaRepository;
import vamos_reciclar_maringa.AEP.repositories.CooperativaRepository;
import vamos_reciclar_maringa.AEP.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgendamentoColetaService {

    @Autowired
    private AgendamentoColetaRepository agendamentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository; // Precisamos dele

    @Autowired
    private CooperativaRepository cooperativaRepository; // E dele

    @Transactional //garante que tudo seja salvo junto (ou nada é salvo)
    public AgendamentoColetaModel criarAgendamento(AgendamentoRequestDTO dto) {

        //busca as entidades por ID
        //o .orElseThrow() lanca um erro se o ID nao for encontrado
        UsuarioModel usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        CooperativaModel cooperativa = cooperativaRepository.findById(dto.getCooperativaId())
                .orElseThrow(() -> new RuntimeException("Cooperativa não encontrada!"));

        //cria um novo agendamento
        AgendamentoColetaModel novoAgendamento = new AgendamentoColetaModel();

        //pega os dados do dto para o model
        novoAgendamento.setUsuario(usuario);
        novoAgendamento.setCooperativa(cooperativa);
        novoAgendamento.setDescricaoItem(dto.getDescricaoItem());
        novoAgendamento.setDataAgendamento(dto.getDataAgendamento());
        novoAgendamento.setStatus("PENDENTE");

        //salva o agendamento no banco
        return agendamentoRepository.save(novoAgendamento);
    }
}