package vamos_reciclar_maringa.AEP.services;

import vamos_reciclar_maringa.AEP.models.CalendarioColetaModel;
import vamos_reciclar_maringa.AEP.repositories.CalendarioColetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CalendarioColetaService {

    @Autowired
    private CalendarioColetaRepository repository;

    public List<CalendarioColetaModel> buscarPorBairro(String bairro) {//lista de bairros com validacao, caso seja nula e nao exista retorna uma lista vazia
        if (bairro == null || bairro.trim().isEmpty()) {
            return List.of();
        }
        return repository.findByBairroContainingIgnoreCase(bairro);
    }
}