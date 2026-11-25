/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.consulta.dao;

import br.com.ifba.consulta.entity.Consulta;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface ConsultaIDao {

    <S extends Consulta> S save(S consulta);

    void delete(Consulta consulta);

    List<Consulta> findAll();

    boolean existsById(Long id);
}