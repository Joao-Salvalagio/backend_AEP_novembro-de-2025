package vamos_reciclar_maringa.AEP.controllers;

import vamos_reciclar_maringa.AEP.dtos.AgendamentoRequestDTO;
import vamos_reciclar_maringa.AEP.models.AgendamentoColetaModel;
import vamos_reciclar_maringa.AEP.services.AgendamentoColetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agendamentos")
@CrossOrigin(origins = "*")
public class AgendamentoColetaController {

    @Autowired
    private AgendamentoColetaService service;

    @PostMapping
    public ResponseEntity<AgendamentoColetaModel> criar(@RequestBody AgendamentoRequestDTO dto) {//criacao utilizando tratamento de erros try/catch
                                                                                                 //try com retorno de sucesso 201 e catch com a excecao de usuario
                                                                                                 //nao encontrado
        try {
            AgendamentoColetaModel novoAgendamento = service.criarAgendamento(dto);
            return new ResponseEntity<>(novoAgendamento, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}