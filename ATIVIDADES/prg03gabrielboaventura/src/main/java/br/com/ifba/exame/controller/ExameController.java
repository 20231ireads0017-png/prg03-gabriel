/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.exame.controller;

/**
 *
 * @author gabri
 */

import br.com.ifba.exame.entity.Exame;
import br.com.ifba.exame.service.ExameIService;
import java.util.List;
import java.util.Objects;

public class ExameController implements ExameIController {

    private final ExameIService service;

    // Recebe o Service por injeção de dependência.
    public ExameController(ExameIService service) {
        this.service = Objects.requireNonNull(service);
    }

    @Override
    public Exame save(Exame exame) {
        return service.save(exame);
    }

    @Override
    public Exame update(Exame exame) {
        return service.update(exame);
    }

    @Override
    public void delete(Exame exame) {
        service.delete(exame);
    }

    @Override
    public List<Exame> findAll() {
        return service.findAll();
    }
}
