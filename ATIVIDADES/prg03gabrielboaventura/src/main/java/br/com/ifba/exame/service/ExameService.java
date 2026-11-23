/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.exame.service;

import br.com.ifba.exame.dao.ExameIDao;
import br.com.ifba.exame.entity.Exame;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabri
 */
@Service
public class ExameService implements ExameIService {

    private final ExameIDao dao;

    public ExameService(ExameIDao dao) {
        this.dao = Objects.requireNonNull(dao);
    }

    @Override
    public Exame save(Exame exame) {
        validarExame(exame);
        return dao.save(exame);
    }

    @Override
    public Exame update(Exame exame) {
        validarExame(exame);

        if (!dao.findAll().contains(exame)) {
            throw new IllegalArgumentException(
                    "Exame não encontrado.");
        }

        return dao.update(exame);
    }

    @Override
    public void delete(Exame exame) {
        if (exame == null) {
            throw new IllegalArgumentException(
                    "Exame não pode ser nulo.");
        }

        if (!dao.findAll().contains(exame)) {
            throw new IllegalArgumentException(
                    "Exame não encontrado.");
        }

        dao.delete(exame);
    }

    @Override
    public List<Exame> findAll() {
        return dao.findAll();
    }

    private void validarExame(Exame exame) {
        if (exame == null) {
            throw new IllegalArgumentException(
                    "Exame não pode ser nulo.");
        }

        if (exame.getEspecialidade() == null
                || exame.getEspecialidade().isBlank()) {
            throw new IllegalArgumentException(
                    "A especialidade é obrigatória.");
        }

        if (exame.getData() == null
                || exame.getData().isBlank()) {
            throw new IllegalArgumentException(
                    "A data do exame é obrigatória.");
        }
    }
}