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
import br.com.ifba.usuario.exception.UsuarioNaoEncontradoException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RepositorioUsuarioJPATest {

    @Test
    public void deveSalvarBuscarEExcluirUsuario() {
        RepositorioUsuarioJPA repositorio = new RepositorioUsuarioJPA();

        String email = "teste.jpa." + System.nanoTime() + "@exemplo.com";
        Usuario usuario = new Usuario(
                "Usuario Teste",
                email,
                "senha-temporaria"
        );

        Long id = null;

        try {
            assertDoesNotThrow(() -> repositorio.salvar(usuario));
            assertNotNull(usuario.getId());
            id = usuario.getId();

            Usuario encontrado = repositorio.buscarPorId(id);

            assertNotNull(encontrado);
            assertEquals("Usuario Teste", encontrado.getNome());
            assertEquals(email, encontrado.getEmail());

            Usuario encontradoPorEmail = repositorio.buscarPorEmail(email);

            assertNotNull(encontradoPorEmail);
            assertEquals(id, encontradoPorEmail.getId());

            assertTrue(
                    repositorio.listarTodos().stream()
                            .anyMatch(u -> idIgual(u.getId(), usuario.getId()))
            );

        } finally {
            // Exclui o usuário de teste mesmo se alguma verificação falhar
            if (id != null) {
                repositorio.excluir(id);
            }
        }

        Long idExcluido = id;

        assertThrows(
                UsuarioNaoEncontradoException.class,
                () -> repositorio.buscarPorId(idExcluido)
        );
    }

    private boolean idIgual(Long primeiro, Long segundo) {
        return java.util.Objects.equals(primeiro, segundo);
    }
}