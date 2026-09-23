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

    // Verifica se um paciente é criado sem consultas
    @Test
    public void deveCriarPacienteSemConsultas() {

        // Cria um novo paciente
        Paciente paciente = new Paciente(
                "Gabriel",
                "123456789"
        );

        // Verifica se a lista de consultas começa vazia
        assertEquals(0, paciente.getConsultas().size());
    }

    // Verifica se uma consulta pode ser adicionada ao paciente
    @Test
    public void deveAdicionarConsultaAoPaciente() {

        // Cria um novo paciente
        Paciente paciente = new Paciente(
                "Gabriel",
                "123456789"
        );

        // Cria uma nova consulta
        Consulta consulta = new Consulta(
                "Cardiologia",
                "25/09/2026"
        );

        // Adiciona a consulta ao paciente
        paciente.adicionarConsulta(consulta);

        // Verifica se a lista passou a possuir uma consulta
        assertEquals(1, paciente.getConsultas().size());
    }

    // Verifica se a consulta adicionada é a mesma armazenada no paciente
    @Test
    public void deveRetornarConsultaAdicionada() {

        // Cria o paciente e a consulta
        Paciente paciente = new Paciente(
                "Gabriel",
                "123456789"
        );

        Consulta consulta = new Consulta(
                "Cardiologia",
                "25/09/2026"
        );

        // Adiciona a consulta ao paciente
        paciente.adicionarConsulta(consulta);

        // Verifica se a consulta armazenada é a mesma que foi adicionada
        assertEquals(consulta, paciente.getConsultas().get(0));
    }
}
