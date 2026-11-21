/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.service;

/**
 *
 * @author gabri
 */

import br.com.ifba.usuario.dao.FakeUsuarioDao;
import br.com.ifba.usuario.entity.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioServiceTest {

    private UsuarioIService service;

    @BeforeEach
    void preparar() {
        // Usa o DAO em memória, sem acessar o MySQL.
        service = new UsuarioService(new FakeUsuarioDao());
    }

    @Test
    void deveCadastrarUsuarioValido() {
        Usuario usuario = new Usuario(
                "Gabriel", "gabriel@email.com", "12345678");

        Usuario salvo = service.save(usuario);

        assertNotNull(salvo.getId());
        assertEquals(1, service.findAll().size());
    }

    @Test
    void deveRejeitarSenhaCurta() {
        Usuario usuario = new Usuario(
                "Gabriel", "gabriel@email.com", "123");

        assertThrows(IllegalArgumentException.class,
                () -> service.save(usuario));
    }

    @Test
    void deveRejeitarEmailComPalavraProibida() {
        Usuario usuario = new Usuario(
                "Gabriel", "admin@email.com", "12345678");

        assertThrows(IllegalArgumentException.class,
                () -> service.save(usuario));
    }

    @Test
    void deveAutenticarUsuarioCorretamente() {
        service.save(new Usuario(
                "Gabriel", "gabriel@email.com", "12345678"));

        assertTrue(service.autenticar(
                "gabriel@email.com", "12345678"));

        assertFalse(service.autenticar(
                "gabriel@email.com", "senhaerrada"));
    }
}
