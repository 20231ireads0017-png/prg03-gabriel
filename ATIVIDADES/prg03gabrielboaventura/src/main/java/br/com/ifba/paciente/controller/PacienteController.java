/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.paciente.controller;

import br.com.ifba.paciente.entity.Paciente;
import br.com.ifba.paciente.service.PacienteIService;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author gabri
 */
public class PacienteController implements PacienteIController {

    private final PacienteIService service;

    public PacienteController(PacienteIService service) {
        this.service = Objects.requireNonNull(service);
    }

    @Override
    public Paciente save(Paciente paciente) {
        return service.save(paciente);
    }

    @Override
    public Paciente update(Paciente paciente) {
        return service.update(paciente);
    }

    @Override
    public void delete(Paciente paciente) {
        service.delete(paciente);
    }

    @Override
    public Paciente findByCartaoSus(String cartaoSus) {
        return service.findByCartaoSus(cartaoSus);
    }

    @Override
    public List<Paciente> findAll() {
        return service.findAll();
    }
}