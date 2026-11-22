/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.dao;

/**
 *
 * @author gabri
 */

import br.com.ifba.infrastructure.dao.DaoException;
import br.com.ifba.usuario.entity.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UsuarioDaoTest {

    @Test
    public void deveLancarExcecaoAoSalvarUsuarioInvalido() {

        UsuarioDao dao = new UsuarioDao();

        Usuario usuario = new Usuario(
                null,
                "teste.dao.invalido@email.com",
                "12345678"
        );

        assertThrows(DaoException.class, () -> {
            dao.save(usuario);
        });
    }
}