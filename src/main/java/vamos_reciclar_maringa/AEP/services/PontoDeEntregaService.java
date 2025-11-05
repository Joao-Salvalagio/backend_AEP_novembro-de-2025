package vamos_reciclar_maringa.AEP.services; // <-- CORRIGIDO

// Importa o Model e o Repository dos pacotes corretos
import vamos_reciclar_maringa.AEP.models.PontoDeEntregaModel; // <-- CORRIGIDO
import vamos_reciclar_maringa.AEP.repositories.PontoDeEntregaRepository; // <-- CORRIGIDO
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PontoDeEntregaService {

    @Autowired
    private PontoDeEntregaRepository repository;

    public List<PontoDeEntregaModel> buscarTodos() {//lista de todos os pontos de entregas cadastrados na nossa aplicacao
        return repository.findAll();
    }
}