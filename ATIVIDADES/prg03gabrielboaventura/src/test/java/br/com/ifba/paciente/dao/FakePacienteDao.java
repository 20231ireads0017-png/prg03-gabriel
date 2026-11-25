/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.paciente.dao;

import br.com.ifba.paciente.entity.Paciente;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author gabri
 */
public class FakePacienteDao implements PacienteIDao {

    private final List<Paciente> pacientes = new ArrayList<>();
    private long proximoId = 1;

    @Override
    public <S extends Paciente> S save(S paciente) {
        if (paciente.getId() == null) {
            paciente.setId(proximoId++);
        }

        for (int i = 0; i < pacientes.size(); i++) {
            if (Objects.equals(pacientes.get(i).getId(),
                    paciente.getId())) {
                pacientes.set(i, paciente);
                return paciente;
            }
        }

        pacientes.add(paciente);
        return paciente;
    }

    @Override
    public void delete(Paciente paciente) {
        pacientes.removeIf(p
                -> Objects.equals(p.getId(), paciente.getId()));
    }

    @Override
    public Paciente findByCartaoSus(String cartaoSus) {
        for (Paciente paciente : pacientes) {
            if (Objects.equals(paciente.getCartaoSus(), cartaoSus)) {
                return paciente;
            }
        }

        return null;
    }

    @Override
    public List<Paciente> findAll() {
        return new ArrayList<>(pacientes);
    }

    @Override
    public boolean existsByCartaoSus(String cartaoSus) {
        return pacientes.stream()
                .anyMatch(p -> Objects.equals(
                p.getCartaoSus(), cartaoSus));
    }
}
