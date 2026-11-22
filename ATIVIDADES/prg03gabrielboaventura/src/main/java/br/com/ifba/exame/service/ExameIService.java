/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.exame.service;

import br.com.ifba.exame.entity.Exame;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface ExameIService {

    Exame save(Exame exame);

    Exame update(Exame exame);

    void delete(Exame exame);

    List<Exame> findAll();
}