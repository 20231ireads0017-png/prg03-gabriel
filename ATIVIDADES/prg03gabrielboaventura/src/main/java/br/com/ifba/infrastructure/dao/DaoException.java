/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

/**
 *
 * @author gabri
 */

public class DaoException extends RuntimeException {

    // Informa o erro ocorrido no acesso ao banco
    public DaoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
