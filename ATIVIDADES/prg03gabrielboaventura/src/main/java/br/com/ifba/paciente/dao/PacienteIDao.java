/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.paciente.dao;

import br.com.ifba.paciente.entity.Paciente;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface PacienteIDao {

    <S extends Paciente> S save(S paciente);

    void delete(Paciente paciente);

    Paciente findByCartaoSus(String cartaoSus);

    boolean existsByCartaoSus(String cartaoSus);

    List<Paciente> findAll();
}