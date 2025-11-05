package vamos_reciclar_maringa.AEP.dtos;

import lombok.Data;

@Data
public class UsuarioCadastroDTO {

    private String nome;
    private String email;
    private String senha;
    private String bairro;
}