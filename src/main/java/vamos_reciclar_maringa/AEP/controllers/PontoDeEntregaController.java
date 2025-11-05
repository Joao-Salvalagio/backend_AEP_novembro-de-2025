package vamos_reciclar_maringa.AEP.controllers;

import vamos_reciclar_maringa.AEP.models.PontoDeEntregaModel;
import vamos_reciclar_maringa.AEP.services.PontoDeEntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pontos-entrega")
@CrossOrigin(origins = "*")
public class PontoDeEntregaController {

    @Autowired
    private PontoDeEntregaService service;

    @GetMapping
    public List<PontoDeEntregaModel> listarTodos() {
        return service.buscarTodos();
    }
}