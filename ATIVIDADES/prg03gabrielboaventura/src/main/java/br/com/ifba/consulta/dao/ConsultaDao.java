/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.consulta.dao;

import br.com.ifba.consulta.entity.Consulta;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gabri
 */
@Repository
public class ConsultaDao implements ConsultaIDao {

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
        // Retorna uma cópia para proteger a lista original.
        return new ArrayList<>(consultas);
    }
}