/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.service;

import br.com.ifba.usuario.dao.UsuarioIDao;
import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.validar.ValidadorUsuario;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabri
 */
@Service
public class UsuarioService implements UsuarioIService {

    private final UsuarioIDao dao;

    public UsuarioService(UsuarioIDao dao) {
        this.dao = Objects.requireNonNull(dao);
    }

    @Override
    public Usuario save(Usuario usuario) {
        validarUsuario(usuario);

        if (dao.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException(
                    "Já existe um usuário com este e-mail.");
        }

        return dao.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        validarUsuario(usuario);
        return dao.save(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        dao.delete(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> findAll() {
        return dao.findAll();
    }

    @Override
    public Usuario findByEmail(String email) {
        return dao.findByEmail(email);
    }

    @Override
    public boolean autenticar(String email, String senha) {
        if (email == null || senha == null) {
            return false;
        }

        Usuario usuario = dao.findByEmail(email.trim());

        return usuario != null
                && usuario.autenticar(email.trim(), senha);
    }

    @Override
    public List<Usuario> pesquisar(String texto) {
        return dao.pesquisar(texto);
    }

    private void validarUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException(
                    "Usuário não pode ser nulo.");
        }

        if (usuario.getNome() == null
                || usuario.getNome().isBlank()
                || usuario.getEmail() == null
                || usuario.getEmail().isBlank()
                || usuario.getSenha() == null
                || usuario.getSenha().isBlank()) {

            throw new IllegalArgumentException(
                    "Preencha todos os campos.");
        }

        if (!ValidadorUsuario.senhaPossuiTamanhoMinimo(usuario.getSenha())) {
            throw new IllegalArgumentException(
                    "A senha deve possuir no mínimo 8 caracteres.");
        }

        if (ValidadorUsuario.contemPalavraProibida(usuario.getEmail())) {
            throw new IllegalArgumentException(
                    "Login contém palavra não permitida.");
        }
    }
}