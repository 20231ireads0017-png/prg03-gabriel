/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.consulta.entity;

/**
 *
 * @author gabri
 */

import br.com.ifba.atendimento.entity.Atendimento;

public class Consulta extends Atendimento {

    // Status da consulta
    private StatusConsulta status;

    // Cria uma consulta com o status inicial AGENDADA
    public Consulta(String especialidade, String data) {
        super(especialidade, data);
        this.status = StatusConsulta.AGENDADA;
    }

    // Retorna o status atual da consulta
    public StatusConsulta getStatus() {
        return status;
    }

    // Altera o status da consulta
    public void setStatus(StatusConsulta status) {
        this.status = status;
    }

    // Retorna o tipo específico do atendimento
    @Override
    public String getTipoAtendimento() {
        return "Consulta";
    }
}