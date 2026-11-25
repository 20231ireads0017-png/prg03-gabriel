/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.exame.dao;

import br.com.ifba.exame.entity.Exame;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface ExameIDao {

    <S extends Exame> S save(S exame);

    void delete(Exame exame);

    List<Exame> findAll();

    boolean existsById(Long id);
}