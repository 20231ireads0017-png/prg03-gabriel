/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.consulta.dao;

import br.com.ifba.consulta.entity.Consulta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author gabri
 */
public class FakeConsultaDao implements ConsultaIDao {

    private final List<Consulta> consultas = new ArrayList<>();
    private long proximoId = 1;

    @Override
    public <S extends Consulta> S save(S consulta) {
        if (consulta.getId() == null) {
            consulta.setId(proximoId++);
        }

        for (int i = 0; i < consultas.size(); i++) {
            if (Objects.equals(consultas.get(i).getId(),
                    consulta.getId())) {
                consultas.set(i, consulta);
                return consulta;
            }
        }

        consultas.add(consulta);
        return consulta;
    }

    @Override
    public void delete(Consulta consulta) {
        consultas.removeIf(c
                -> Objects.equals(c.getId(), consulta.getId()));
    }

    @Override
    public List<Consulta> findAll() {
        return new ArrayList<>(consultas);
    }

    @Override
    public boolean existsById(Long id) {
        return consultas.stream()
                .anyMatch(c -> Objects.equals(c.getId(), id));
    }
}
