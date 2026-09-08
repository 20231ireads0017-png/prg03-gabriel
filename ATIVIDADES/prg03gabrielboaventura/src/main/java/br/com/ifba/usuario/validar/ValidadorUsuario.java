/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.validar;

/**
 *
 * @author gabri
 */
public class ValidadorUsuario {
    // Verifica se o texto contém alguma palavra proibida
    public static boolean contemPalavraProibida(String texto) {

        // Palavras que não são permitidas
        String[] palavrasProibidas = {"admin", "teste", "root", "senha123"};

        // Percorre todas as palavras proibidas
        for (String palavra : palavrasProibidas) {
            if (texto.contains(palavra)) {
                return true;
            }
        }

        // Nenhuma palavra proibida foi encontrada
        return false;
    }
}
