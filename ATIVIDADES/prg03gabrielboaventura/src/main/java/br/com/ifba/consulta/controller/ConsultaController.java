/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.consulta.controller;

/**
 *
 * @author gabri
 */

import br.com.ifba.consulta.entity.Consulta;
import br.com.ifba.consulta.service.ConsultaIService;
import java.util.List;
import java.util.Objects;

public class ConsultaController implements ConsultaIController {

    private final ConsultaIService service;

    // Recebe o Service por injeção de dependência.
    public ConsultaController(ConsultaIService service) {
        this.service = Objects.requireNonNull(service);
    }

    @Override
    public Consulta save(Consulta consulta) {
        return service.save(consulta);
    }

    @Override
    public Consulta update(Consulta consulta) {
        return service.update(consulta);
    }

    @Override
    public void delete(Consulta consulta) {
        service.delete(consulta);
    }

    @Override
    public List<Consulta> findAll() {
        return service.findAll();
    }
}

