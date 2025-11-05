package vamos_reciclar_maringa.AEP.services;

import vamos_reciclar_maringa.AEP.dtos.LoginRequestDTO;
import vamos_reciclar_maringa.AEP.dtos.UsuarioCadastroDTO;
import vamos_reciclar_maringa.AEP.models.UsuarioModel;
import vamos_reciclar_maringa.AEP.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public UsuarioModel cadastrarUsuario(UsuarioCadastroDTO dto) {//metodo de cadastro do usuario com validacao se o email ja esta cadastrado ou nao

        if (repository.findByEmail(dto.getEmail()) != null) {
            throw new RuntimeException("Este e-mail já está cadastrado!");
        }

        String senhaCriptografada = passwordEncoder.encode(dto.getSenha());

        UsuarioModel novoUsuario = new UsuarioModel();
        novoUsuario.setNome(dto.getNome());
        novoUsuario.setEmail(dto.getEmail());
        novoUsuario.setBairro(dto.getBairro());
        novoUsuario.setSenha(senhaCriptografada);

        return repository.save(novoUsuario);
    }

    public UsuarioModel autenticar(LoginRequestDTO dto) { //logica para autenticacao de usuario
        //busca o usuario pelo email
        UsuarioModel usuario = repository.findByEmail(dto.getEmail());

        if (usuario == null) {
            throw new RuntimeException("Usuário ou senha inválidos.");
        }

        //compara a senha do DTO (data transfer object) e compara com a senha criptografada no banco
        if (passwordEncoder.matches(dto.getSenha(), usuario.getSenha())) {
            //se estiver correta
            return usuario;
        } else {
            //se nao estiver correta
            throw new RuntimeException("Usuário ou senha inválidos.");
        }
    }
}