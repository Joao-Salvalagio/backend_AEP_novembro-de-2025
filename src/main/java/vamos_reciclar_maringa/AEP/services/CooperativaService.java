package vamos_reciclar_maringa.AEP.services;

import vamos_reciclar_maringa.AEP.models.CooperativaModel;
import vamos_reciclar_maringa.AEP.repositories.CooperativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CooperativaService {

    @Autowired
    private CooperativaRepository repository;

    public List<CooperativaModel> buscarTodas() {//lista para todas cooperativas cadastradas na nossa aplicacao
        return repository.findAll();
    }
}