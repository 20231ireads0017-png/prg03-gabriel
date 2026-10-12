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

public class RepositorioUsuarioJPATest {

    @Test
    public void deveSalvarBuscarEExcluirUsuario() {
        RepositorioUsuarioJPA repositorio = new RepositorioUsuarioJPA();

        // Cria um usuário apenas para o teste
        String email = "teste.jpa." + System.nanoTime() + "@exemplo.com";
        Usuario usuario = new Usuario(
                "Usuario Teste",
                email,
                "senha-temporaria"
        );

        Long id = null;

        try {
            // Salva o usuário no MySQL
            repositorio.salvar(usuario);

            assertNotNull(usuario.getId());
            id = usuario.getId();

            // Busca pelo ID
            Usuario encontrado = repositorio.buscarPorId(id);

            assertNotNull(encontrado);
            assertEquals("Usuario Teste", encontrado.getNome());
            assertEquals(email, encontrado.getEmail());

            // Busca pelo e-mail
            Usuario encontradoPorEmail = repositorio.buscarPorEmail(email);

            assertNotNull(encontradoPorEmail);
            assertEquals(id, encontradoPorEmail.getId());

            // Verifica se aparece na listagem
            assertTrue(
                    repositorio.listarTodos().stream()
                            .anyMatch(u -> idIgual(u.getId(), usuario.getId()))
            );

            System.out.println("Cadastro e consultas JPA realizados com sucesso!");

        } finally {
            // Remove o usuário de teste, mesmo se alguma verificação falhar
            if (id != null) {
                repositorio.excluir(id);
            }
        }

        // Confirma que o usuário foi excluído
        assertNull(repositorio.buscarPorId(id));
        System.out.println("Exclusão JPA realizada com sucesso!");
    }

    private boolean idIgual(Long primeiro, Long segundo) {
        return java.util.Objects.equals(primeiro, segundo);
    }
}

