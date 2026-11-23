/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.exame.dao;

import br.com.ifba.exame.entity.Exame;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gabri
 */
@Repository
public class ExameDao implements ExameIDao {

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
        // Retorna uma cópia para proteger a lista original.
        return new ArrayList<>(exames);
    }
}