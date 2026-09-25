/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.exame.entity;

/**
 *
 * @author gabri
 */

import br.com.ifba.atendimento.entity.Atendimento;

public class Exame extends Atendimento {

    // Cria um novo exame
    public Exame(String especialidade, String data) {
        super(especialidade, data);
    }

    // Retorna o tipo específico do atendimento
    @Override
    public String getTipoAtendimento() {
        return "Exame";
    }
}
