/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.consulta.entity;

import br.com.ifba.atendimento.entity.Atendimento;

/**
 *
 * @author gabri
 */
public class Consulta extends Atendimento {

    private StatusConsulta status;

    public Consulta(String especialidade, String data) {
        super(especialidade, data);
        this.status = StatusConsulta.AGENDADA;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }

    @Override
    public String getTipoAtendimento() {
        return "Consulta";
    }
}