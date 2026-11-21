/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.consulta.controller;

/**
 *
 * @author gabri
 */

import br.com.ifba.consulta.entity.Consulta;
import java.util.List;

public interface ConsultaIController {

    Consulta save(Consulta consulta);

    Consulta update(Consulta consulta);

    void delete(Consulta consulta);

    List<Consulta> findAll();
}

