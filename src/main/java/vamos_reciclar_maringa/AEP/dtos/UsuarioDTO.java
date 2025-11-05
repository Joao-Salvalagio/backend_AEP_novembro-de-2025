package vamos_reciclar_maringa.AEP.dtos;

import lombok.Data;
import vamos_reciclar_maringa.AEP.models.UsuarioModel;

@Data
public class UsuarioDTO {

    private Integer id;
    private String nome;
    private String email;
    private String bairro;

    //conversao de model para DTO
    public UsuarioDTO(UsuarioModel model) {
        this.id = model.getId();
        this.nome = model.getNome();
        this.email = model.getEmail();
        this.bairro = model.getBairro();
    }
}