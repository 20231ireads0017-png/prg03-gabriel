/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prg03gabrielboaventura;

import br.com.ifba.atendimento.entity.ProcessadorAtendimento;
import br.com.ifba.consulta.entity.Consulta;
import br.com.ifba.exame.entity.Exame;
import br.com.ifba.infra.jpa.FlywayUtil;

/**
 *
 * @author gabri
 */
public class Prg03gabrielboaventura {

    public static void main(String[] args) {
        prepararBancoDeDados();
        demonstrarProcessamentoAtendimentos();
    }

    private static void prepararBancoDeDados() {
        FlywayUtil.migrar();
    }

    private static void demonstrarProcessamentoAtendimentos() {
        ProcessadorAtendimento processador = new ProcessadorAtendimento();

        Consulta consulta = new Consulta("Cardiologia", "27/09/2026");
        Exame exame = new Exame("Radiologia", "27/09/2026");

        System.out.println(processador.processar(consulta));
        System.out.println(processador.processar(exame));
    }
}