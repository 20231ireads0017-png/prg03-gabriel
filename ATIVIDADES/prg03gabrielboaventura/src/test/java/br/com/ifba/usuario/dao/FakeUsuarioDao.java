/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.dao;

/**
 *
 * @author gabri
 */

import br.com.ifba.usuario.entity.Usuario;
import java.util.ArrayList;
import java.util.List;

public class FakeUsuarioDao implements UsuarioIDao {

    private final List<Usuario> usuarios = new ArrayList<>();
    private long proximoId = 1;

    @Override
    public Usuario save(Usuario usuario) {
        usuario.setId(proximoId++);
        usuarios.add(usuario);
        return usuario;
    }

    @Override
    public Usuario update(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId().equals(usuario.getId())) {
                usuarios.set(i, usuario);
                return usuario;
            }
        }
        throw new IllegalArgumentException("Usuário não encontrado.");
    }

    @Override
    public void delete(Usuario usuario) {
        usuarios.removeIf(u -> u.getId().equals(usuario.getId()));
    }

    @Override
    public Usuario findById(Long id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        return new ArrayList<>(usuarios);
    }

    @Override
    public Usuario findByEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public List<Usuario> pesquisar(String texto) {
        List<Usuario> resultado = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            if (usuario.getNome().contains(texto)
                    || usuario.getEmail().contains(texto)) {
                resultado.add(usuario);
            }
        }

        return resultado;
    }
}

