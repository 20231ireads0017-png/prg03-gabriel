/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.exame.entity;

/**
 *
 * @author gabri
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExameTest {

    // Verifica se Exame herda o comportamento de Atendimento
    @Test
    public void deveHerdarDadosDoAtendimento() {

        // Cria um novo exame
        Exame exame = new Exame(
                "Radiologia",
                "26/09/2026"
        );

        // Usa métodos herdados da classe Atendimento
        assertEquals("Radiologia", exame.getEspecialidade());
        assertEquals("26/09/2026", exame.getData());
    }

    // Verifica se Exame sobrescreve o tipo do atendimento
    @Test
    public void deveRetornarTipoExame() {

        // Cria um novo exame
        Exame exame = new Exame(
                "Radiologia",
                "26/09/2026"
        );

        // Verifica o comportamento sobrescrito
        assertEquals("Exame", exame.getTipoAtendimento());
    }
}