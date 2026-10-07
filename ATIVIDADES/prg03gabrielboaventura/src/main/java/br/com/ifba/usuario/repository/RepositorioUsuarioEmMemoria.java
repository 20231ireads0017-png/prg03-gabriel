/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.repository;

import br.com.ifba.usuario.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author gabri
 */

public class RepositorioUsuarioEmMemoria {

    // Lista que guarda os usuários cadastrados
    private final List<Usuario> usuarios = new ArrayList<>();
    
    // Mapa que relaciona o login ao usuário
    private final Map<String, Usuario> porLogin = new HashMap<>();

    // Adiciona um usuário à lista e ao mapa
    public void cadastrar(Usuario usuario) {

        // Verifica se o login já está cadastrado
        if (porLogin.containsKey(usuario.getEmail())) {
            throw new IllegalArgumentException("Login já cadastrado");
        }

        usuarios.add(usuario);
        porLogin.put(usuario.getEmail(), usuario);
    }

    // Retorna todos os usuários cadastrados
    public List<Usuario> listarTodos() {
        return usuarios;
    }
    
    // Busca um usuário pelo login usando o mapa
    public Usuario buscarPorLogin(String login) {
        return porLogin.get(login);
    }
}
