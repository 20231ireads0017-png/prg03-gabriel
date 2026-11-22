/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.consulta.service;

import br.com.ifba.consulta.entity.Consulta;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface ConsultaIService {

    Consulta save(Consulta consulta);

    Consulta update(Consulta consulta);

    void delete(Consulta consulta);

    List<Consulta> findAll();
}