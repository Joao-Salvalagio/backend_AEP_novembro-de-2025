package vamos_reciclar_maringa.AEP.repositories;

import vamos_reciclar_maringa.AEP.models.AgendamentoColetaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoColetaRepository extends JpaRepository<AgendamentoColetaModel, Integer> {
}