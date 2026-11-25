/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.consulta.repository;

import br.com.ifba.consulta.dao.ConsultaIDao;
import br.com.ifba.consulta.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gabri
 */
public interface ConsultaRepository
        extends JpaRepository<Consulta, Long>, ConsultaIDao {

    @Override
    <S extends Consulta> S save(S consulta);

    @Override
    boolean existsById(Long id);
}