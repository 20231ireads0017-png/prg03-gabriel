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

    private static final String[] PALAVRAS_PROIBIDAS_PADRAO = {
        "admin", "teste", "root", "senha123"
    };

    public static boolean todosOsCamposPreenchidos(String nome, String email,
            String senha, String confirmarSenha) {

        return nome != null && !nome.isEmpty()
                && email != null && !email.isEmpty()
                && senha != null && !senha.isEmpty()
                && confirmarSenha != null && !confirmarSenha.isEmpty();
    }

    public static boolean senhasCoincidem(String senha, String confirmarSenha) {
        return senha != null && senha.equals(confirmarSenha);
    }

    public static boolean senhaPossuiTamanhoMinimo(String senha) {
        return senha != null && senha.length() >= 8;
    }

    public static boolean contemPalavraProibida(String texto) {
        return contemPalavraProibida(texto, PALAVRAS_PROIBIDAS_PADRAO);
    }

    public static boolean contemPalavraProibida(String texto,
            String[] palavrasProibidas) {

        if (texto == null) {
            return false;
        }

        java.util.Objects.requireNonNull(palavrasProibidas);

        for (String palavra : palavrasProibidas) {
            if (texto.contains(palavra)) {
                return true;
            }
        }

        return false;
    }
}