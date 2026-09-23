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

public class ConsultaTest {

    // Verifica se uma nova consulta começa com o status AGENDADA
    @Test
    public void deveCriarConsultaComStatusAgendada() {

        // Cria uma nova consulta
        Consulta consulta = new Consulta(
                "Cardiologia",
                "25/09/2026"
        );

        // Verifica se o status inicial é AGENDADA
        assertEquals(StatusConsulta.AGENDADA, consulta.getStatus());
    }

    // Verifica se o status da consulta pode ser alterado
    @Test
    public void deveAlterarStatusDaConsulta() {

        // Cria uma nova consulta
        Consulta consulta = new Consulta(
                "Cardiologia",
                "25/09/2026"
        );

        // Altera o status da consulta
        consulta.setStatus(StatusConsulta.REALIZADA);

        // Verifica se o status foi alterado
        assertEquals(StatusConsulta.REALIZADA, consulta.getStatus());
    }
}
