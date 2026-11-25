/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.usuario.dao;

import br.com.ifba.usuario.entity.Usuario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author gabri
 */
public interface UsuarioIDao {

    <S extends Usuario> S save(S usuario);

    void delete(Usuario usuario);

    Optional<Usuario> findById(Long id);

    List<Usuario> findAll();

    Usuario findByEmail(String email);

    boolean existsByEmail(String email);

    List<Usuario> pesquisar(String texto);
}