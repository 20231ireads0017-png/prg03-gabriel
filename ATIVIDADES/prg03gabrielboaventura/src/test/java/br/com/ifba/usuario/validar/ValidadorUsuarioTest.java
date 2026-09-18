/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.com.ifba.usuario.validar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author gabri
 */

public class ValidadorUsuarioTest {

    @Test
    public void deveRetornarTrueQuandoCamposEstaoPreenchidos() {
        assertTrue(ValidadorUsuario.camposPreenchidos(
                "Gabriel", "gabriel@email.com", "12345678", "12345678"));
    }

    @Test
    public void deveRetornarFalseQuandoCampoEstaVazio() {
        assertFalse(ValidadorUsuario.camposPreenchidos(
                "", "gabriel@email.com", "12345678", "12345678"));
    }

    @Test
    public void deveRetornarFalseQuandoCampoForNull() {
        assertFalse(ValidadorUsuario.camposPreenchidos(
                null, "gabriel@email.com", "12345678", "12345678"));
    }

    @Test
    public void deveRetornarTrueQuandoSenhasCoincidem() {
        assertTrue(ValidadorUsuario.senhasCoincidem(
                "12345678", "12345678"));
    }

    @Test
    public void deveRetornarFalseQuandoSenhasNaoCoincidem() {
        assertFalse(ValidadorUsuario.senhasCoincidem(
                "12345678", "87654321"));
    }

    @Test
    public void deveRetornarFalseQuandoSenhaForNullAoComparar() {
        assertFalse(ValidadorUsuario.senhasCoincidem(
                null, null));
    }

    @Test
    public void deveRetornarTrueQuandoSenhaTemOitoCaracteres() {
        assertTrue(ValidadorUsuario.senhaForte("12345678"));
    }

    @Test
    public void deveRetornarFalseQuandoSenhaTemMenosDeOitoCaracteres() {
        assertFalse(ValidadorUsuario.senhaForte("1234567"));
    }

    @Test
    public void deveRetornarFalseQuandoSenhaForNull() {
        assertFalse(ValidadorUsuario.senhaForte(null));
    }

    @Test
    public void deveEncontrarPalavraProibida() {
        assertTrue(ValidadorUsuario.contemPalavraProibida(
                "admin@email.com"));
    }

    @Test
    public void naoDeveEncontrarPalavraProibida() {
        assertFalse(ValidadorUsuario.contemPalavraProibida(
                "gabriel@email.com"));
    }

    @Test
    public void naoDeveEncontrarPalavraProibidaQuandoTextoForNull() {
        assertFalse(ValidadorUsuario.contemPalavraProibida(null));
    }
}