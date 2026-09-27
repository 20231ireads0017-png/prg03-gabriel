/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prg03gabrielboaventura;

/**
 *
 * @author gabri
 */

import br.com.ifba.atendimento.entity.ProcessadorAtendimento;
import br.com.ifba.consulta.entity.Consulta;
import br.com.ifba.exame.entity.Exame;

public class Prg03gabrielboaventura {

    public static void main(String[] args) {

        // Cria o processador de atendimentos
        ProcessadorAtendimento processador = new ProcessadorAtendimento();

        // Cria uma consulta e um exame
        Consulta consulta = new Consulta("Cardiologia", "27/09/2026");
        Exame exame = new Exame("Radiologia", "27/09/2026");

        // Processa os dois tipos de atendimento
        System.out.println(processador.processar(consulta));
        System.out.println(processador.processar(exame));
    }
}
