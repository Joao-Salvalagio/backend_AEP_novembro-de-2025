package vamos_reciclar_maringa.AEP.repositories;

import vamos_reciclar_maringa.AEP.models.CalendarioColetaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CalendarioColetaRepository extends JpaRepository<CalendarioColetaModel, Integer> {
    List<CalendarioColetaModel> findByBairroContainingIgnoreCase(String bairro);
}