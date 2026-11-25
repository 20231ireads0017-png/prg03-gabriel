/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.integration;

import br.com.ifba.consulta.entity.Consulta;
import br.com.ifba.consulta.entity.StatusConsulta;
import br.com.ifba.consulta.repository.ConsultaRepository;
import br.com.ifba.consulta.service.ConsultaService;
import br.com.ifba.exame.entity.Exame;
import br.com.ifba.exame.repository.ExameRepository;
import br.com.ifba.exame.service.ExameService;
import br.com.ifba.paciente.entity.Paciente;
import br.com.ifba.paciente.repository.PacienteRepository;
import br.com.ifba.paciente.service.PacienteService;
import com.mycompany.prg03gabrielboaventura.ProjetoApplication;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.UUID;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.orm.jpa.SharedEntityManagerCreator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

/**
 *
 * @author gabri
 */
public class PersistenciaRepositoryTest {

    private static ConfigurableApplicationContext context;
    private static TransactionTemplate transaction;
    private static EntityManager entityManager;

    private static PacienteRepository pacienteRepository;
    private static ConsultaRepository consultaRepository;
    private static ExameRepository exameRepository;

    private static PacienteService pacienteService;
    private static ConsultaService consultaService;
    private static ExameService exameService;

    @BeforeAll
    public static void configurar() {
        context = new SpringApplicationBuilder(ProjetoApplication.class)
                .headless(true)
                .lazyInitialization(true)
                .run();

        pacienteRepository = context.getBean(PacienteRepository.class);
        consultaRepository = context.getBean(ConsultaRepository.class);
        exameRepository = context.getBean(ExameRepository.class);

        pacienteService = context.getBean(PacienteService.class);
        consultaService = context.getBean(ConsultaService.class);
        exameService = context.getBean(ExameService.class);

        transaction = new TransactionTemplate(
                context.getBean(PlatformTransactionManager.class));

        entityManager = SharedEntityManagerCreator
                .createSharedEntityManager(
                        context.getBean(EntityManagerFactory.class));
    }

    @AfterAll
    public static void finalizar() {
        if (context != null) {
            context.close();
        }
    }

    // Sincroniza as alterações com o banco e limpa o contexto JPA.
    private void sincronizarBanco() {
        entityManager.flush();
        entityManager.clear();
    }

    // Verifica as operações de persistência de pacientes.
    @Test
    public void devePersistirPaciente() {
        transaction.executeWithoutResult(status -> {
            status.setRollbackOnly();

            String cartaoSus = UUID.randomUUID().toString();

            Paciente paciente = pacienteService.save(
                    new Paciente("Paciente Teste", cartaoSus));

            assertNotNull(paciente.getId());

            sincronizarBanco();

            assertTrue(
                    pacienteRepository.existsByCartaoSus(cartaoSus));

            Paciente encontrado =
                    pacienteService.findByCartaoSus(cartaoSus);

            assertNotNull(encontrado);
            assertEquals("Paciente Teste", encontrado.getNome());

            // Verifica a regra de cartão SUS único.
            assertThrows(IllegalArgumentException.class, () ->
                    pacienteService.save(
                            new Paciente("Outro Paciente", cartaoSus)));

            encontrado.setNome("Paciente Atualizado");
            pacienteService.update(encontrado);

            sincronizarBanco();

            Paciente atualizado =
                    pacienteService.findByCartaoSus(cartaoSus);

            assertEquals("Paciente Atualizado", atualizado.getNome());

            pacienteService.delete(atualizado);

            sincronizarBanco();

            assertFalse(
                    pacienteRepository.existsByCartaoSus(cartaoSus));
        });
    }

    // Verifica as operações de persistência de consultas.
    @Test
    public void devePersistirConsulta() {
        transaction.executeWithoutResult(status -> {
            status.setRollbackOnly();

            Consulta consulta = consultaService.save(
                    new Consulta("Cardiologia", "25/11/2026"));

            Long id = consulta.getId();

            assertNotNull(id);

            sincronizarBanco();

            assertTrue(consultaRepository.existsById(id));

            Consulta encontrada = consultaRepository.findById(id)
                    .orElseThrow();

            assertEquals("Cardiologia",
                    encontrada.getEspecialidade());

            assertEquals(StatusConsulta.AGENDADA,
                    encontrada.getStatus());

            encontrada.setStatus(StatusConsulta.REALIZADA);
            consultaService.update(encontrada);

            sincronizarBanco();

            Consulta atualizada = consultaRepository.findById(id)
                    .orElseThrow();

            assertEquals(StatusConsulta.REALIZADA,
                    atualizada.getStatus());

            consultaService.delete(atualizada);

            sincronizarBanco();

            assertFalse(consultaRepository.existsById(id));
        });
    }

    // Verifica as operações de persistência de exames.
    @Test
    public void devePersistirExame() {
        transaction.executeWithoutResult(status -> {
            status.setRollbackOnly();

            Exame exame = exameService.save(
                    new Exame("Hemograma", "25/11/2026"));

            Long id = exame.getId();

            assertNotNull(id);

            sincronizarBanco();

            assertTrue(exameRepository.existsById(id));

            Exame encontrado = exameRepository.findById(id)
                    .orElseThrow();

            assertEquals("Hemograma",
                    encontrado.getEspecialidade());

            encontrado.setData("26/11/2026");
            exameService.update(encontrado);

            sincronizarBanco();

            Exame atualizado = exameRepository.findById(id)
                    .orElseThrow();

            assertEquals("26/11/2026", atualizado.getData());

            exameService.delete(atualizado);

            sincronizarBanco();

            assertFalse(exameRepository.existsById(id));
        });
    }

    // Verifica o relacionamento entre paciente e consulta.
    @Test
    public void devePersistirRelacionamentoPacienteConsulta() {
        transaction.executeWithoutResult(status -> {
            status.setRollbackOnly();

            String cartaoSus = UUID.randomUUID().toString();

            Consulta consulta = consultaService.save(
                    new Consulta("Clínica Geral", "25/11/2026"));

            Paciente paciente =
                    new Paciente("Paciente Teste", cartaoSus);

            paciente.adicionarConsulta(consulta);

            pacienteService.save(paciente);

            sincronizarBanco();

            Paciente encontrado =
                    pacienteService.findByCartaoSus(cartaoSus);

            assertNotNull(encontrado);
            assertEquals(1, encontrado.getConsultas().size());

            assertEquals(consulta.getId(),
                    encontrado.getConsultas().get(0).getId());

            // Verifica se a atualização preserva o relacionamento.
            encontrado.setNome("Paciente Atualizado");
            pacienteService.update(encontrado);

            sincronizarBanco();

            Paciente atualizado =
                    pacienteService.findByCartaoSus(cartaoSus);

            assertEquals("Paciente Atualizado", atualizado.getNome());
            assertEquals(1, atualizado.getConsultas().size());

            assertEquals(consulta.getId(),
                    atualizado.getConsultas().get(0).getId());
        });
    }
}