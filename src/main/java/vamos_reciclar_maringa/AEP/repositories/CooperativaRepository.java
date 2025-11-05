package vamos_reciclar_maringa.AEP.repositories;

import vamos_reciclar_maringa.AEP.models.CooperativaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CooperativaRepository extends JpaRepository<CooperativaModel, Integer> {
}