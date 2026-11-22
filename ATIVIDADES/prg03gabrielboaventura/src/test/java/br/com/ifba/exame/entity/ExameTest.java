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
import br.com.ifba.atendimento.entity.Atendimento;

public class ExameTest {

    @Test
    public void deveHerdarDadosDoAtendimento() {
        Exame exame = new Exame(
                "Radiologia",
                "26/09/2026"
        );

        assertEquals("Radiologia", exame.getEspecialidade());
        assertEquals("26/09/2026", exame.getData());
    }

    @Test
    public void deveRetornarTipoExame() {
        Exame exame = new Exame(
                "Radiologia",
                "26/09/2026"
        );

        assertEquals("Exame", exame.getTipoAtendimento());
    }

    @Test
    public void deveUsarExameComoAtendimento() {
        Atendimento atendimento = new Exame(
                "Radiologia",
                "26/09/2026"
        );

        assertEquals("Exame", atendimento.getTipoAtendimento());
    }
}