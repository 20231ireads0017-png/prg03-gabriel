/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.paciente.entity;

/**
 *
 * @author gabri
 */

import br.com.ifba.consulta.entity.Consulta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PacienteTest {

    @Test
    public void deveCriarPacienteSemConsultas() {
        Paciente paciente = new Paciente(
                "Gabriel",
                "123456789"
        );

        assertEquals(0, paciente.getConsultas().size());
    }

    @Test
    public void deveAdicionarConsultaAoPaciente() {
        Paciente paciente = new Paciente(
                "Gabriel",
                "123456789"
        );

        Consulta consulta = new Consulta(
                "Cardiologia",
                "25/09/2026"
        );

        paciente.adicionarConsulta(consulta);

        assertEquals(1, paciente.getConsultas().size());
    }

    @Test
    public void deveRetornarConsultaAdicionada() {
        Paciente paciente = new Paciente(
                "Gabriel",
                "123456789"
        );

        Consulta consulta = new Consulta(
                "Cardiologia",
                "25/09/2026"
        );

        paciente.adicionarConsulta(consulta);

        assertEquals(consulta, paciente.getConsultas().get(0));
    }
}