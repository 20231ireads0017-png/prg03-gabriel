/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.paciente.controller;

import br.com.ifba.paciente.entity.Paciente;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface PacienteIController {

    Paciente save(Paciente paciente);

    Paciente update(Paciente paciente);

    void delete(Paciente paciente);

    Paciente findByCartaoSus(String cartaoSus);

    List<Paciente> findAll();
}