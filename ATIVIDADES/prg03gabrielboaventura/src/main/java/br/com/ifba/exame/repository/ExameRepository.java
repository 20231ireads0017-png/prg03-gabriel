/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.exame.repository;

import br.com.ifba.exame.dao.ExameIDao;
import br.com.ifba.exame.entity.Exame;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gabri
 */
public interface ExameRepository
        extends JpaRepository<Exame, Long>, ExameIDao {

    @Override
    <S extends Exame> S save(S exame);

    @Override
    boolean existsById(Long id);
}