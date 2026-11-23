/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.consulta.service;

import br.com.ifba.consulta.dao.ConsultaIDao;
import br.com.ifba.consulta.entity.Consulta;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabri
 */
@Service
public class ConsultaService implements ConsultaIService {

    private final ConsultaIDao dao;

    public ConsultaService(ConsultaIDao dao) {
        this.dao = Objects.requireNonNull(dao);
    }

    @Override
    public Consulta save(Consulta consulta) {
        validarConsulta(consulta);
        return dao.save(consulta);
    }

    @Override
    public Consulta update(Consulta consulta) {
        validarConsulta(consulta);

        if (!dao.findAll().contains(consulta)) {
            throw new IllegalArgumentException(
                    "Consulta não encontrada.");
        }

        return dao.update(consulta);
    }

    @Override
    public void delete(Consulta consulta) {
        if (consulta == null) {
            throw new IllegalArgumentException(
                    "Consulta não pode ser nula.");
        }

        if (!dao.findAll().contains(consulta)) {
            throw new IllegalArgumentException(
                    "Consulta não encontrada.");
        }

        dao.delete(consulta);
    }

    @Override
    public List<Consulta> findAll() {
        return dao.findAll();
    }

    private void validarConsulta(Consulta consulta) {
        if (consulta == null) {
            throw new IllegalArgumentException(
                    "Consulta não pode ser nula.");
        }

        if (consulta.getEspecialidade() == null
                || consulta.getEspecialidade().isBlank()) {
            throw new IllegalArgumentException(
                    "A especialidade é obrigatória.");
        }

        if (consulta.getData() == null
                || consulta.getData().isBlank()) {
            throw new IllegalArgumentException(
                    "A data da consulta é obrigatória.");
        }
    }
}