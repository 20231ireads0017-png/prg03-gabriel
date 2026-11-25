/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.dao;

import br.com.ifba.usuario.entity.Usuario;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

/**
 *
 * @author gabri
 */
public class FakeUsuarioDao implements UsuarioIDao {

    private final List<Usuario> usuarios = new ArrayList<>();
    private long proximoId = 1;

    @Override
    public <S extends Usuario> S save(S usuario) {
        if (usuario.getId() == null) {
            usuario.setId(proximoId++);
        }

        for (int i = 0; i < usuarios.size(); i++) {
            if (Objects.equals(usuarios.get(i).getId(),
                    usuario.getId())) {
                usuarios.set(i, usuario);
                return usuario;
            }
        }

        usuarios.add(usuario);
        return usuario;
    }

    @Override
    public void delete(Usuario usuario) {
        usuarios.removeIf(u ->
                Objects.equals(u.getId(), usuario.getId()));
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        for (Usuario usuario : usuarios) {
            if (Objects.equals(usuario.getId(), id)) {
                return Optional.of(usuario);
            }
        }

        return Optional.empty();
    }

    @Override
    public List<Usuario> findAll() {
        return new ArrayList<>(usuarios);
    }

    @Override
    public Usuario findByEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (Objects.equals(usuario.getEmail(), email)) {
                return usuario;
            }
        }

        return null;
    }

    @Override
    public boolean existsByEmail(String email) {
        return usuarios.stream()
                .anyMatch(u -> Objects.equals(u.getEmail(), email));
    }

    @Override
    public List<Usuario> pesquisar(String texto) {
        List<Usuario> resultado = new ArrayList<>();
        String termo = texto.toLowerCase(Locale.ROOT);

        for (Usuario usuario : usuarios) {
            if (usuario.getNome().toLowerCase(Locale.ROOT).contains(termo)
                    || usuario.getEmail().toLowerCase(Locale.ROOT).contains(termo)) {
                resultado.add(usuario);
            }
        }

        resultado.sort(Comparator.comparing(
                Usuario::getNome, String.CASE_INSENSITIVE_ORDER));

        return resultado;
    }
}