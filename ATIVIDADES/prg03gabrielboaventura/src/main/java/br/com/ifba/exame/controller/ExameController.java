/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.exame.controller;

import br.com.ifba.exame.entity.Exame;
import br.com.ifba.exame.service.ExameIService;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Controller;

/**
 *
 * @author gabri
 */
@Controller
public class ExameController implements ExameIController {

    private final ExameIService service;

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