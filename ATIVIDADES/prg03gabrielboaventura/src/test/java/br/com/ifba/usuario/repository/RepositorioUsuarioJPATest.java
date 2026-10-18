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

        // Cria um usuário exclusivo para o teste
        String email = "teste.jpa." + System.nanoTime() + "@exemplo.com";
        Usuario usuario = new Usuario(
                "Usuario Teste",
                email,
                "senha-temporaria"
        );

        Long id = null;

        try {
            // Cadastra e verifica se o ID foi gerado
            assertDoesNotThrow(() -> repositorio.salvar(usuario));
            assertNotNull(usuario.getId());
            id = usuario.getId();

            // Verifica a busca por ID
            Usuario encontrado = repositorio.buscarPorId(id);

            assertNotNull(encontrado);
            assertEquals("Usuario Teste", encontrado.getNome());
            assertEquals(email, encontrado.getEmail());

            // Verifica a busca por e-mail
            Usuario encontradoPorEmail = repositorio.buscarPorEmail(email);

            assertNotNull(encontradoPorEmail);
            assertEquals(id, encontradoPorEmail.getId());

            // Verifica se o usuário aparece na listagem
            assertTrue(
                    repositorio.listarTodos().stream()
                            .anyMatch(u -> idIgual(u.getId(), usuario.getId()))
            );

            System.out.println("Cadastro e consultas JPA realizados com sucesso!");

        } finally {
            // Exclui o usuário de teste mesmo se alguma verificação falhar
            if (id != null) {
                repositorio.excluir(id);
            }
        }

        // Verifica se a busca de um usuário excluído lança a exceção esperada
        Long idExcluido = id;

        assertThrows(
                UsuarioNaoEncontradoException.class,
                () -> repositorio.buscarPorId(idExcluido)
        );

        System.out.println("Exclusão e tratamento de exceção realizados com sucesso!");
    }

    private boolean idIgual(Long primeiro, Long segundo) {
        return java.util.Objects.equals(primeiro, segundo);
    }
}