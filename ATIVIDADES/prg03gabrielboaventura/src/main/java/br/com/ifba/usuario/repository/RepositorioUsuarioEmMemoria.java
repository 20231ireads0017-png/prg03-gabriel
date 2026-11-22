/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.repository;

import br.com.ifba.usuario.entity.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gabri
 */
public class RepositorioUsuarioEmMemoria {

    private final List<Usuario> usuarios = new ArrayList<>();
    private final Map<String, Usuario> porLogin = new HashMap<>();

    public void cadastrar(Usuario usuario) {
        if (porLogin.containsKey(usuario.getEmail())) {
            throw new IllegalArgumentException("Login já cadastrado");
        }

        usuarios.add(usuario);
        porLogin.put(usuario.getEmail(), usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarios;
    }

    public Usuario buscarPorLogin(String login) {
        return porLogin.get(login);
    }
}