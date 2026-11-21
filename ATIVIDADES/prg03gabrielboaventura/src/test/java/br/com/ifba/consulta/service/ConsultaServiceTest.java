/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.consulta.service;

/**
 *
 * @author gabri
 */

import br.com.ifba.consulta.dao.FakeConsultaDao;
import br.com.ifba.consulta.entity.Consulta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConsultaServiceTest {

    private ConsultaIService service;

    @BeforeEach
    void preparar() {
        // Cada teste utiliza um DAO falso independente.
        service = new ConsultaService(new FakeConsultaDao());
    }

    @Test
    void deveCadastrarConsulta() {
        Consulta consulta = new Consulta("Cardiologia", "20/11/2026");

        service.save(consulta);

        assertEquals(1, service.findAll().size());
        assertSame(consulta, service.findAll().get(0));
    }

    @Test
    void naoDeveCadastrarConsultaSemEspecialidade() {
        Consulta consulta = new Consulta("", "20/11/2026");

        assertThrows(IllegalArgumentException.class,
                () -> service.save(consulta));
    }

    @Test
    void naoDeveCadastrarConsultaSemData() {
        Consulta consulta = new Consulta("Cardiologia", "");

        assertThrows(IllegalArgumentException.class,
                () -> service.save(consulta));
    }

    @Test
    void deveAtualizarConsulta() {
        Consulta consulta = new Consulta("Cardiologia", "20/11/2026");
        service.save(consulta);

        consulta.setData("25/11/2026");
        service.update(consulta);

        assertEquals("25/11/2026", service.findAll().get(0).getData());
    }

    @Test
    void deveExcluirConsulta() {
        Consulta consulta = new Consulta("Cardiologia", "20/11/2026");
        service.save(consulta);

        service.delete(consulta);

        assertTrue(service.findAll().isEmpty());
    }
}

