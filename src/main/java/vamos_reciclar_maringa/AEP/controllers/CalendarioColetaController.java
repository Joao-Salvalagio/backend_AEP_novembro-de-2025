package vamos_reciclar_maringa.AEP.controllers;

import vamos_reciclar_maringa.AEP.models.CalendarioColetaModel;
import vamos_reciclar_maringa.AEP.services.CalendarioColetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/calendarios")
@CrossOrigin(origins = "*") //permissao para qualquer requisicao acessar nossa api, como é local nao tem problema essa "falta de seguranca"
public class CalendarioColetaController {

    @Autowired
    private CalendarioColetaService service;

    @GetMapping("/buscar")
    public ResponseEntity<List<CalendarioColetaModel>> buscarPorBairro(@RequestParam("bairro") String bairro) {
        List<CalendarioColetaModel> resultados = service.buscarPorBairro(bairro);
        return ResponseEntity.ok(resultados);
    }
}