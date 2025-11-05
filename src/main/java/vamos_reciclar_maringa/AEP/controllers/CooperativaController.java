package vamos_reciclar_maringa.AEP.controllers;

import vamos_reciclar_maringa.AEP.models.CooperativaModel;
import vamos_reciclar_maringa.AEP.services.CooperativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cooperativas")
@CrossOrigin(origins = "*") //permissao para qualquer requisicao acessar nossa api, como é local nao tem problema essa "falta de seguranca"
public class CooperativaController {

    @Autowired
    private CooperativaService service;

    @GetMapping
    public List<CooperativaModel> listarTodas() {
        return service.buscarTodas();
    }
}