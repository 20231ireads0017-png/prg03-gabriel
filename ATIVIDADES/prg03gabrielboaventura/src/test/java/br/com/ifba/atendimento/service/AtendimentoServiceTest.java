/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atendimento.service;

/**
 *
 * @author gabri
 */

import br.com.ifba.atendimento.entity.ProcessadorAtendimento;
import br.com.ifba.consulta.entity.Consulta;
import br.com.ifba.exame.entity.Exame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AtendimentoServiceTest {

    private AtendimentoIService service;

    @BeforeEach
    void preparar() {
        // Injeta o processador sem acessar o banco de dados.
        service = new AtendimentoService(new ProcessadorAtendimento());
    }

    @Test
    void deveProcessarConsulta() {
        Consulta consulta = new Consulta("Cardiologia", "20/11/2026");

        assertEquals("Consulta", service.processar(consulta));
    }

    @Test
    void deveProcessarExame() {
        Exame exame = new Exame("Radiologia", "20/11/2026");

        assertEquals("Exame", service.processar(exame));
    }

    @Test
    void naoDeveProcessarAtendimentoNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> service.processar(null));
    }

    @Test
    void naoDeveProcessarAtendimentoSemEspecialidade() {
        Consulta consulta = new Consulta("", "20/11/2026");

        assertThrows(IllegalArgumentException.class,
                () -> service.processar(consulta));
    }

    @Test
    void naoDeveProcessarAtendimentoSemData() {
        Exame exame = new Exame("Radiologia", "");

        assertThrows(IllegalArgumentException.class,
                () -> service.processar(exame));
    }
}

