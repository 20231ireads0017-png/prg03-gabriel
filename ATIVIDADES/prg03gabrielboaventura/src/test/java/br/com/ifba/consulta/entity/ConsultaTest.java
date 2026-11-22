/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.consulta.entity;

/**
 *
 * @author gabri
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import br.com.ifba.atendimento.entity.Atendimento;

public class ConsultaTest {

    @Test
    public void deveCriarConsultaComStatusAgendada() {
        Consulta consulta = new Consulta(
                "Cardiologia",
                "25/09/2026"
        );

        assertEquals(StatusConsulta.AGENDADA, consulta.getStatus());
    }

    @Test
    public void deveAlterarStatusDaConsulta() {
        Consulta consulta = new Consulta(
                "Cardiologia",
                "25/09/2026"
        );

        consulta.setStatus(StatusConsulta.REALIZADA);

        assertEquals(StatusConsulta.REALIZADA, consulta.getStatus());
    }

    @Test
    public void deveHerdarDadosDoAtendimento() {
        Consulta consulta = new Consulta(
                "Cardiologia",
                "25/09/2026"
        );

        assertEquals("Cardiologia", consulta.getEspecialidade());
        assertEquals("25/09/2026", consulta.getData());
    }

    @Test
    public void deveRetornarTipoConsulta() {
        Consulta consulta = new Consulta(
                "Cardiologia",
                "25/09/2026"
        );

        assertEquals("Consulta", consulta.getTipoAtendimento());
    }

    @Test
    public void deveUsarConsultaComoAtendimento() {
        Atendimento atendimento = new Consulta(
                "Cardiologia",
                "25/09/2026"
        );

        assertEquals("Consulta", atendimento.getTipoAtendimento());
    }
}