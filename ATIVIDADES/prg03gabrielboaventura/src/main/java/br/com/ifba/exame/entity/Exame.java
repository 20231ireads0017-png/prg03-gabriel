/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.exame.entity;

import br.com.ifba.atendimento.entity.Atendimento;

/**
 *
 * @author gabri
 */
public class Exame extends Atendimento {

    public Exame(String especialidade, String data) {
        super(especialidade, data);
    }

    @Override
    public String getTipoAtendimento() {
        return "Exame";
    }
}