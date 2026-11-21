/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.paciente.service;

/**
 *
 * @author gabri
 */

import br.com.ifba.paciente.dao.FakePacienteDao;
import br.com.ifba.paciente.entity.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PacienteServiceTest {

    private PacienteIService service;

    @BeforeEach
    void preparar() {
        // Cada teste utiliza um DAO em memória independente.
        service = new PacienteService(new FakePacienteDao());
    }

    @Test
    void deveCadastrarPaciente() {
        Paciente paciente = new Paciente("Maria", "123456789012345");

        service.save(paciente);

        assertEquals(1, service.findAll().size());
        assertSame(paciente, service.findByCartaoSus("123456789012345"));
    }

    @Test
    void naoDeveCadastrarPacienteSemNome() {
        Paciente paciente = new Paciente("", "123456789012345");

        assertThrows(IllegalArgumentException.class,
                () -> service.save(paciente));
    }

    @Test
    void naoDeveCadastrarCartaoSusDuplicado() {
        service.save(new Paciente("Maria", "123456789012345"));

        Paciente outro = new Paciente("João", "123456789012345");

        assertThrows(IllegalArgumentException.class,
                () -> service.save(outro));
    }

    @Test
    void deveExcluirPaciente() {
        Paciente paciente = new Paciente("Maria", "123456789012345");
        service.save(paciente);

        service.delete(paciente);

        assertTrue(service.findAll().isEmpty());
    }
}

