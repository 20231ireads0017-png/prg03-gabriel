/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.exame.dao;

/**
 *
 * @author gabri
 */

import br.com.ifba.exame.entity.Exame;
import java.util.ArrayList;
import java.util.List;

public class FakeExameDao implements ExameIDao {

    // Simula o armazenamento dos exames sem banco de dados.
    private final List<Exame> exames = new ArrayList<>();

    @Override
    public Exame save(Exame exame) {
        exames.add(exame);
        return exame;
    }

    @Override
    public Exame update(Exame exame) {
        int indice = exames.indexOf(exame);

        if (indice == -1) {
            throw new IllegalArgumentException(
                    "Exame não encontrado.");
        }

        exames.set(indice, exame);
        return exame;
    }

    @Override
    public void delete(Exame exame) {
        exames.remove(exame);
    }

    @Override
    public List<Exame> findAll() {
        return new ArrayList<>(exames);
    }
}

