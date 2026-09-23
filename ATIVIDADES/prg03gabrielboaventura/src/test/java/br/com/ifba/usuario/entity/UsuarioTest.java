/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.com.ifba.usuario.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import br.com.ifba.paciente.entity.Paciente;

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
    
    // Verifica o relacionamento entre Usuario e Paciente
    @Test
    public void deveRelacionarPacienteAoUsuario() {

        // Cria um novo usuário
        Usuario usuario = new Usuario(
            "Gabriel",
            "gabriel@email.com",
            "12345678"
        );

        // Cria um novo paciente
        Paciente paciente = new Paciente(
            "Gabriel",
            "123456789"
        );

        // Relaciona o paciente ao usuário
        usuario.setPaciente(paciente);

        // Verifica se o paciente retornado é o mesmo que foi relacionado
        assertEquals(paciente, usuario.getPaciente());
    }
}