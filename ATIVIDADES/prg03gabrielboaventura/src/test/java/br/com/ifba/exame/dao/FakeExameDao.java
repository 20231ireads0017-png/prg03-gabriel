/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.exame.dao;

import br.com.ifba.exame.entity.Exame;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author gabri
 */
public class FakeExameDao implements ExameIDao {

    private final List<Exame> exames = new ArrayList<>();
    private long proximoId = 1;

    @Override
    public <S extends Exame> S save(S exame) {
        if (exame.getId() == null) {
            exame.setId(proximoId++);
        }

        for (int i = 0; i < exames.size(); i++) {
            if (Objects.equals(exames.get(i).getId(),
                    exame.getId())) {
                exames.set(i, exame);
                return exame;
            }
        }

        exames.add(exame);
        return exame;
    }

    @Override
    public void delete(Exame exame) {
        exames.removeIf(e
                -> Objects.equals(e.getId(), exame.getId()));
    }

    @Override
    public List<Exame> findAll() {
        return new ArrayList<>(exames);
    }

    @Override
    public boolean existsById(Long id) {
        return exames.stream()
                .anyMatch(e -> Objects.equals(e.getId(), id));
    }
}
