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
public class PacienteDao implements PacienteIDao {

    private final List<Paciente> pacientes = new ArrayList<>();

    @Override
    public Paciente save(Paciente paciente) {
        pacientes.add(paciente);
        return paciente;
    }

    @Override
    public Paciente update(Paciente paciente) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (Objects.equals(pacientes.get(i).getCartaoSus(),
                    paciente.getCartaoSus())) {
                pacientes.set(i, paciente);
                return paciente;
            }
        }

        throw new IllegalArgumentException("Paciente não encontrado.");
    }

    @Override
    public void delete(Paciente paciente) {
        pacientes.removeIf(p ->
                Objects.equals(p.getCartaoSus(), paciente.getCartaoSus()));
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
}