/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.usuario.repository;

import br.com.ifba.usuario.dao.UsuarioIDao;
import br.com.ifba.usuario.entity.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author gabri
 */
public interface UsuarioRepository
        extends JpaRepository<Usuario, Long>, UsuarioIDao {

    @Override
    <S extends Usuario> S save(S usuario);

    @Override
    Usuario findByEmail(String email);

    @Override
    boolean existsByEmail(String email);

    @Override
    @Query("SELECT u FROM Usuario u "
            + "WHERE LOWER(u.nome) LIKE CONCAT('%', LOWER(:texto), '%') "
            + "OR LOWER(u.email) LIKE CONCAT('%', LOWER(:texto), '%') "
            + "ORDER BY u.nome ASC")
    List<Usuario> pesquisar(@Param("texto") String texto);
}