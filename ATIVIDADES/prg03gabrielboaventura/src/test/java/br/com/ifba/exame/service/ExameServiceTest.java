/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.exame.service;

/**
 *
 * @author gabri
 */

import br.com.ifba.exame.dao.FakeExameDao;
import br.com.ifba.exame.entity.Exame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExameServiceTest {

    private ExameIService service;

    @BeforeEach
    void preparar() {
        service = new ExameService(new FakeExameDao());
    }

    @Test
    void deveCadastrarExame() {
        Exame exame = new Exame("Radiologia", "20/11/2026");

        service.save(exame);

        assertEquals(1, service.findAll().size());
        assertSame(exame, service.findAll().get(0));
    }

    @Test
    void naoDeveCadastrarExameSemEspecialidade() {
        Exame exame = new Exame("", "20/11/2026");

        assertThrows(IllegalArgumentException.class,
                () -> service.save(exame));
    }

    @Test
    void naoDeveCadastrarExameSemData() {
        Exame exame = new Exame("Radiologia", "");

        assertThrows(IllegalArgumentException.class,
                () -> service.save(exame));
    }

    @Test
    void deveAtualizarExame() {
        Exame exame = new Exame("Radiologia", "20/11/2026");
        service.save(exame);

        exame.setData("25/11/2026");
        service.update(exame);

        assertEquals("25/11/2026", service.findAll().get(0).getData());
    }

    @Test
    void deveExcluirExame() {
        Exame exame = new Exame("Radiologia", "20/11/2026");
        service.save(exame);

        service.delete(exame);

        assertTrue(service.findAll().isEmpty());
    }
}