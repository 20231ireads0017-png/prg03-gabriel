/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.com.ifba.usuario.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gabri
 */

public class UsuarioTest {

    @Test
    public void deveAutenticarQuandoCredenciaisEstaoCorretas() {
        Usuario usuario =
                new Usuario("Gabriel", "gabriel@email.com", "12345678");

        boolean resultado =
                usuario.autenticar("gabriel@email.com", "12345678");

        assertTrue(resultado);
    }

    @Test
    public void naoDeveAutenticarQuandoSenhaEstaIncorreta() {
        Usuario usuario =
                new Usuario("Gabriel", "gabriel@email.com", "12345678");

        boolean resultado =
                usuario.autenticar("gabriel@email.com", "senhaErrada");

        assertFalse(resultado);
    }
}