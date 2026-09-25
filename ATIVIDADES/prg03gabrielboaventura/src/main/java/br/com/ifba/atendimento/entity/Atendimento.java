/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atendimento.entity;

/**
 *
 * @author gabri
 */

public class Atendimento {

    // Dados comuns aos atendimentos
    private String especialidade;
    private String data;

    // Cria um novo atendimento
    public Atendimento(String especialidade, String data) {
        this.especialidade = especialidade;
        this.data = data;
    }

    // Retorna a especialidade do atendimento
    public String getEspecialidade() {
        return especialidade;
    }

    // Altera a especialidade do atendimento
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    // Retorna a data do atendimento
    public String getData() {
        return data;
    }

    // Altera a data do atendimento
    public void setData(String data) {
        this.data = data;
    }

    // Retorna o tipo do atendimento
    public String getTipoAtendimento() {
        return "Atendimento";
    }
}