/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.repository;

/**
 *
 * @author gabri
 */

import br.com.ifba.usuario.entity.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RepositorioUsuarioEmMemoriaTest {

    // Verifica se o usuário cadastrado aparece na lista
    @Test
    public void deveCadastrarUsuarioEListar() {
        RepositorioUsuarioEmMemoria repositorio =
                new RepositorioUsuarioEmMemoria();

        Usuario usuario =
                new Usuario("Gabriel", "gabriel@email.com", "12345678");

        repositorio.cadastrar(usuario);

        assertTrue(repositorio.listarTodos().contains(usuario));
    }

    // Verifica se a busca pelo login retorna o usuário correto
    @Test
    public void deveBuscarUsuarioPorLogin() {
        RepositorioUsuarioEmMemoria repositorio =
                new RepositorioUsuarioEmMemoria();

        Usuario usuario1 =
                new Usuario("Gabriel", "gabriel@email.com", "12345678");

        Usuario usuario2 =
                new Usuario("João", "joao@email.com", "87654321");

        repositorio.cadastrar(usuario1);
        repositorio.cadastrar(usuario2);

        Usuario resultado =
                repositorio.buscarPorLogin("joao@email.com");

        assertEquals(usuario2, resultado);
    }

    // Verifica a busca por um login que não existe
    @Test
    public void deveRetornarNullQuandoLoginNaoExiste() {
        RepositorioUsuarioEmMemoria repositorio =
                new RepositorioUsuarioEmMemoria();

        Usuario resultado =
                repositorio.buscarPorLogin("naoexiste@email.com");

        assertNull(resultado);
    }

    // Verifica se não é permitido cadastrar o mesmo login duas vezes
    @Test
    public void naoDeveCadastrarLoginDuplicado() {
        RepositorioUsuarioEmMemoria repositorio =
                new RepositorioUsuarioEmMemoria();

        Usuario usuario1 =
                new Usuario("Gabriel", "gabriel@email.com", "12345678");

        Usuario usuario2 =
                new Usuario("Outro Gabriel", "gabriel@email.com", "outraSenha");

        repositorio.cadastrar(usuario1);

        assertThrows(
                IllegalArgumentException.class,
                () -> repositorio.cadastrar(usuario2)
        );
    }
}