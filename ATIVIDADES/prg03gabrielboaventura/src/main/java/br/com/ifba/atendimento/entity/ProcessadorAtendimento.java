/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atendimento.entity;

/**
 *
 * @author gabri
 */

public class ProcessadorAtendimento {

    // Retorna o tipo do atendimento recebido
    public String processar(Atendimento atendimento) {
        return atendimento.getTipoAtendimento();
    }
}
