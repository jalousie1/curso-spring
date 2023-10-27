package com.mercadinholegal.apiteste.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadinholegal.apiteste.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UsuarioPojo {

    @JsonProperty("id_usuario")
    private Long id;

    @JsonProperty("nome_usuario")
    private String nome;

    @JsonProperty("senha_usuario")
    private String senha;

    public UsuarioPojo() {}

    public UsuarioPojo(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
    }

    @JsonIgnore
    public Usuario toEntity() {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNome(nome);
        usuario.setSenha(senha);
        return usuario;
    }

}
