/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.paciente.dao;

import br.com.ifba.paciente.entity.Paciente;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface PacienteIDao {

    Paciente save(Paciente paciente);

    Paciente update(Paciente paciente);

    void delete(Paciente paciente);

    Paciente findByCartaoSus(String cartaoSus);

    List<Paciente> findAll();
}