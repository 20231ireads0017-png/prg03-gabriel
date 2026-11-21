/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atendimento.service;

/**
 *
 * @author gabri
 */

import br.com.ifba.atendimento.entity.Atendimento;
import br.com.ifba.atendimento.entity.ProcessadorAtendimento;
import java.util.Objects;

public class AtendimentoService implements AtendimentoIService {

    private final ProcessadorAtendimento processador;

    // Recebe o processador por injeção de dependência.
    public AtendimentoService(ProcessadorAtendimento processador) {
        this.processador = Objects.requireNonNull(processador);
    }

    @Override
    public String processar(Atendimento atendimento) {
        // Valida os dados antes do processamento.
        if (atendimento == null) {
            throw new IllegalArgumentException(
                    "Atendimento não pode ser nulo.");
        }

        if (atendimento.getEspecialidade() == null
                || atendimento.getEspecialidade().isBlank()) {
            throw new IllegalArgumentException(
                    "A especialidade é obrigatória.");
        }

        if (atendimento.getData() == null
                || atendimento.getData().isBlank()) {
            throw new IllegalArgumentException(
                    "A data do atendimento é obrigatória.");
        }

        return processador.processar(atendimento);
    }
}

