/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atendimento.controller;

import br.com.ifba.atendimento.entity.Atendimento;
import br.com.ifba.atendimento.service.AtendimentoIService;
import java.util.Objects;
import org.springframework.stereotype.Controller;

/**
 *
 * @author gabri
 */
@Controller
public class AtendimentoController implements AtendimentoIController {

    private final AtendimentoIService service;

    public AtendimentoController(AtendimentoIService service) {
        this.service = Objects.requireNonNull(service);
    }

    @Override
    public String processar(Atendimento atendimento) {
        return service.processar(atendimento);
    }
}