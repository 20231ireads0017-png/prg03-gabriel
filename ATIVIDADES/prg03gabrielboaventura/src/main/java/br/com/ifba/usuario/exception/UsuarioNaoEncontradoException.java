/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.exception;

/**
 *
 * @author gabri
 */

// Exceção personalizada para quando um usuário não for encontrado
// Herda de RuntimeException para permitir seu lançamento durante a execução
public class UsuarioNaoEncontradoException extends RuntimeException {

    // Construtor que recebe o ID do usuário não encontrado
    public UsuarioNaoEncontradoException(Long id) {

        // Informando qual usuário não foi encontrado
        super("Usuário com ID " + id + " não foi encontrado.");
    }
}
