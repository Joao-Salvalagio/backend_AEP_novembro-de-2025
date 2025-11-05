package vamos_reciclar_maringa.AEP.controllers;

import vamos_reciclar_maringa.AEP.dtos.LoginRequestDTO;
import vamos_reciclar_maringa.AEP.dtos.UsuarioCadastroDTO;
import vamos_reciclar_maringa.AEP.dtos.UsuarioDTO;
import vamos_reciclar_maringa.AEP.models.UsuarioModel;
import vamos_reciclar_maringa.AEP.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody UsuarioCadastroDTO dto) { //metodo de cadastro
        try {
            UsuarioModel novoUsuario = service.cadastrarUsuario(dto);
            return new ResponseEntity<>(new UsuarioDTO(novoUsuario), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO dto) { //metodo de login
        try {
            UsuarioModel usuarioLogado = service.autenticar(dto);
            return new ResponseEntity<>(new UsuarioDTO(usuarioLogado), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED); // 401
        }
    }
}