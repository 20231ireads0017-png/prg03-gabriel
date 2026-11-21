/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atendimento.controller;

/**
 *
 * @author gabri
 */

import br.com.ifba.atendimento.entity.Atendimento;
import br.com.ifba.atendimento.service.AtendimentoIService;
import java.util.Objects;

public class AtendimentoController implements AtendimentoIController {

    private final AtendimentoIService service;

    // Recebe o Service por injeção de dependência.
    public AtendimentoController(AtendimentoIService service) {
        this.service = Objects.requireNonNull(service);
    }

    @Override
    public String processar(Atendimento atendimento) {
        return service.processar(atendimento);
    }
}

