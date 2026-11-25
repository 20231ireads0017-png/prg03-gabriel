/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.paciente.repository;

import br.com.ifba.paciente.dao.PacienteIDao;
import br.com.ifba.paciente.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gabri
 */
public interface PacienteRepository
        extends JpaRepository<Paciente, Long>, PacienteIDao {

    @Override
    <S extends Paciente> S save(S paciente);

    @Override
    Paciente findByCartaoSus(String cartaoSus);

    @Override
    boolean existsByCartaoSus(String cartaoSus);
}