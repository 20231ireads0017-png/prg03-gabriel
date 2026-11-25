/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.repository;

import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.service.UsuarioService;
import com.mycompany.prg03gabrielboaventura.ProjetoApplication;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

/**
 *
 * @author gabri
 */
public class UsuarioRepositoryTest {

    private static ConfigurableApplicationContext context;
    private static UsuarioRepository repository;
    private static UsuarioService service;
    private static TransactionTemplate transaction;

    @BeforeAll
    public static void configurar() {
        context = new SpringApplicationBuilder(ProjetoApplication.class)
                .headless(true)
                .lazyInitialization(true)
                .run();

        repository = context.getBean(UsuarioRepository.class);
        service = context.getBean(UsuarioService.class);

        transaction = new TransactionTemplate(
                context.getBean(PlatformTransactionManager.class));
    }

    @AfterAll
    public static void finalizar() {
        if (context != null) {
            context.close();
        }
    }

    // Task 04: consulta derivada para verificar e-mails cadastrados.
    @Test
    public void deveVerificarEmailExistente() {
        transaction.executeWithoutResult(status -> {
            status.setRollbackOnly();

            String email = UUID.randomUUID() + "@example.com";

            assertFalse(repository.existsByEmail(email));

            service.save(new Usuario(
                    "Usuario Teste", email, "senha123"));

            assertTrue(repository.existsByEmail(email));

            assertThrows(IllegalArgumentException.class, () ->
                    service.save(new Usuario(
                            "Outro Usuario", email, "senha456")));
        });
    }

    // Verifica a preservação da regra original de autenticação.
    @Test
    public void deveAutenticarSomenteComCredenciaisValidas() {
        transaction.executeWithoutResult(status -> {
            status.setRollbackOnly();

            String email = UUID.randomUUID() + "@example.com";
            String senha = "senha123";

            service.save(new Usuario(
                    "Usuario Teste", email, senha));

            assertTrue(service.autenticar(email, senha));

            assertFalse(service.autenticar(email, "senhaErrada"));

            assertFalse(service.autenticar(email, "SENHA123"));

            assertFalse(service.autenticar(email, "senha123 "));

            assertFalse(service.autenticar(
                    email.toUpperCase(Locale.ROOT), senha));

            assertFalse(service.autenticar(
                    "inexistente-" + email, senha));
        });
    }

    // Task 05: pesquisa por nome ou e-mail com ordenação.
    @Test
    public void devePesquisarPorNomeOuEmailEmOrdemAlfabetica() {
        transaction.executeWithoutResult(status -> {
            status.setRollbackOnly();

            String termo = UUID.randomUUID().toString();

            Usuario primeiro = new Usuario(
                    "Ana " + termo,
                    "ana-" + UUID.randomUUID() + "@example.com",
                    "senha123");

            Usuario segundo = new Usuario(
                    "Bruno",
                    termo + "@example.com",
                    "senha123");

            Usuario terceiro = new Usuario(
                    "Carlos",
                    "carlos-" + UUID.randomUUID() + "@example.com",
                    "senha123");

            repository.save(segundo);
            repository.save(terceiro);
            repository.save(primeiro);

            List<Usuario> resultado = repository.pesquisar(termo);

            assertEquals(2, resultado.size());
            assertEquals(primeiro.getId(), resultado.get(0).getId());
            assertEquals(segundo.getId(), resultado.get(1).getId());
        });
    }
}