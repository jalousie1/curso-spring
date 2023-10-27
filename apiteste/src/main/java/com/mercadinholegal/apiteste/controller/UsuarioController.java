package com.mercadinholegal.apiteste.controller;

import com.mercadinholegal.apiteste.entity.Usuario;
import com.mercadinholegal.apiteste.pojo.UsuarioPojo;
import com.mercadinholegal.apiteste.repository.UsuarioRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<UsuarioPojo> getAll() {
        List<Usuario> listUsuario = usuarioRepository.findAll();
        List<UsuarioPojo> listUsuarioPojo = new ArrayList<>();
        for (Usuario usuario: listUsuario) {
            listUsuarioPojo.add(new UsuarioPojo(usuario));
        }
        return listUsuarioPojo;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UsuarioPojo> get(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        return usuarioOptional.map(usuario -> ResponseEntity.ok(new UsuarioPojo(usuario))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioPojo> create(@RequestBody @Validated UsuarioPojo usuarioPojo) {
        Usuario usuario = usuarioRepository.save(usuarioPojo.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioPojo);
    }

    @PutMapping
    public ResponseEntity<UsuarioPojo> update(@RequestBody @Validated UsuarioPojo usuarioPojo) {
        Usuario usuario = usuarioRepository.findById(usuarioPojo.toEntity().getId()).get();
        usuario.setNome(usuarioPojo.toEntity().getNome());
        usuario.setSenha(usuarioPojo.toEntity().getSenha());
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuarioPojo);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
