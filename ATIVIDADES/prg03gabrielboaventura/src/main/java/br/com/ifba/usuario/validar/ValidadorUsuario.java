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

    // Verifica se todos os campos foram preenchidos
    public static boolean camposPreenchidos(String nome, String email,
            String senha, String confirmarSenha) {

        return nome != null && !nome.isEmpty()
                && email != null && !email.isEmpty()
                && senha != null && !senha.isEmpty()
                && confirmarSenha != null && !confirmarSenha.isEmpty();
    }

    // Verifica se as senhas são iguais
    public static boolean senhasCoincidem(String senha, String confirmarSenha) {
        return senha != null && senha.equals(confirmarSenha);
    }
    
    // Verifica se a senha possui no mínimo 8 caracteres
    public static boolean senhaForte(String senha) {
        return senha != null && senha.length() >= 8;
    }
    
    // Verifica se o texto contém alguma palavra proibida
    public static boolean contemPalavraProibida(String texto) {
        
        if (texto == null) {
            return false;
        }

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