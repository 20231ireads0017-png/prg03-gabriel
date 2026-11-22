/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.com.ifba.usuario.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import br.com.ifba.paciente.entity.Paciente;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void deveRelacionarPacienteAoUsuario() {
        Usuario usuario = new Usuario(
                "Gabriel",
                "gabriel@email.com",
                "12345678"
        );

        Paciente paciente = new Paciente(
                "Gabriel",
                "123456789"
        );

        usuario.setPaciente(paciente);

        assertEquals(paciente, usuario.getPaciente());
    }

    @Test
    public void deveConsiderarUsuariosComMesmoEmailIguais() {
        Usuario usuario1 = new Usuario(
                "Gabriel",
                "gabriel@email.com",
                "12345678"
        );

        Usuario usuario2 = new Usuario(
                "Outro Nome",
                "gabriel@email.com",
                "outraSenha"
        );

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);

        assertTrue(usuarios.contains(usuario2));
    }
}