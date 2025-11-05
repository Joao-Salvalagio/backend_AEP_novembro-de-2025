package vamos_reciclar_maringa.AEP.repositories;

import vamos_reciclar_maringa.AEP.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
    UsuarioModel findByEmail(String email);
}