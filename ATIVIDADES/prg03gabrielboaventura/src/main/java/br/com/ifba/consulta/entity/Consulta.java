/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.consulta.entity;

/**
 *
 * @author gabri
 */

public class Consulta {

    // Dados da consulta
    private String especialidade;
    private String data;
    private StatusConsulta status;

    // Cria uma consulta com o status inicial AGENDADA
    public Consulta(String especialidade, String data) {
        this.especialidade = especialidade;
        this.data = data;
        this.status = StatusConsulta.AGENDADA;
    }

    // Retorna a especialidade da consulta
    public String getEspecialidade() {
        return especialidade;
    }

    // Altera a especialidade da consulta
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    // Retorna a data da consulta
    public String getData() {
        return data;
    }

    // Altera a data da consulta
    public void setData(String data) {
        this.data = data;
    }

    // Retorna o status atual da consulta
    public StatusConsulta getStatus() {
        return status;
    }

    // Altera o status da consulta
    public void setStatus(StatusConsulta status) {
        this.status = status;
    }
}