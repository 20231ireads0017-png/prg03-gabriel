/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.consulta.dao;

/**
 *
 * @author gabri
 */

import br.com.ifba.consulta.entity.Consulta;
import java.util.ArrayList;
import java.util.List;

public class FakeConsultaDao implements ConsultaIDao {

    // Simula o armazenamento das consultas sem banco de dados.
    private final List<Consulta> consultas = new ArrayList<>();

    @Override
    public Consulta save(Consulta consulta) {
        consultas.add(consulta);
        return consulta;
    }

    @Override
    public Consulta update(Consulta consulta) {
        int indice = consultas.indexOf(consulta);

        if (indice == -1) {
            throw new IllegalArgumentException(
                    "Consulta não encontrada.");
        }

        consultas.set(indice, consulta);
        return consulta;
    }

    @Override
    public void delete(Consulta consulta) {
        consultas.remove(consulta);
    }

    @Override
    public List<Consulta> findAll() {
        return new ArrayList<>(consultas);
    }
}

