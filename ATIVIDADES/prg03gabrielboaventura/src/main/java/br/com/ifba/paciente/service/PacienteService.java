/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.paciente.service;

import br.com.ifba.paciente.dao.PacienteIDao;
import br.com.ifba.paciente.entity.Paciente;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabri
 */
@Service
public class PacienteService implements PacienteIService {

    private final PacienteIDao dao;

    public PacienteService(PacienteIDao dao) {
        this.dao = Objects.requireNonNull(dao);
    }

    @Override
    public Paciente save(Paciente paciente) {
        validarPaciente(paciente);

        // Impede o cadastro de cartões SUS duplicados.
        if (dao.existsByCartaoSus(paciente.getCartaoSus())) {
            throw new IllegalArgumentException(
                    "Já existe um paciente com este cartão SUS.");
        }

        return dao.save(paciente);
    }

    @Override
    public Paciente update(Paciente paciente) {
        validarPaciente(paciente);

        Paciente existente
                = dao.findByCartaoSus(paciente.getCartaoSus());

        if (existente == null) {
            throw new IllegalArgumentException(
                    "Paciente não encontrado.");
        }

        paciente.setId(existente.getId());

        return dao.save(paciente);
    }

    @Override
    public void delete(Paciente paciente) {
        if (paciente == null || paciente.getCartaoSus() == null) {
            throw new IllegalArgumentException(
                    "Paciente inválido.");
        }

        Paciente existente
                = dao.findByCartaoSus(paciente.getCartaoSus());

        if (existente == null) {
            throw new IllegalArgumentException(
                    "Paciente não encontrado.");
        }

        dao.delete(existente);
    }

    @Override
    public Paciente findByCartaoSus(String cartaoSus) {
        if (cartaoSus == null || cartaoSus.isBlank()) {
            throw new IllegalArgumentException(
                    "O cartão SUS é obrigatório.");
        }

        return dao.findByCartaoSus(cartaoSus);
    }

    @Override
    public List<Paciente> findAll() {
        return dao.findAll();
    }

    private void validarPaciente(Paciente paciente) {
        if (paciente == null) {
            throw new IllegalArgumentException(
                    "Paciente não pode ser nulo.");
        }

        if (paciente.getNome() == null
                || paciente.getNome().isBlank()) {
            throw new IllegalArgumentException(
                    "O nome do paciente é obrigatório.");
        }

        if (paciente.getCartaoSus() == null
                || paciente.getCartaoSus().isBlank()) {
            throw new IllegalArgumentException(
                    "O cartão SUS é obrigatório.");
        }
    }
}
