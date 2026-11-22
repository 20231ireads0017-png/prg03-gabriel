/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.paciente.entity;

import br.com.ifba.consulta.entity.Consulta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
public class Paciente {

    private String nome;
    private String cartaoSus;
    private List<Consulta> consultas;

    public Paciente(String nome, String cartaoSus) {
        this.nome = nome;
        this.cartaoSus = cartaoSus;
        this.consultas = new ArrayList<>();
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCartaoSus() {
        return cartaoSus;
    }

    public void setCartaoSus(String cartaoSus) {
        this.cartaoSus = cartaoSus;
    }

    // Retorna uma cópia para proteger a lista interna contra alterações externas.
    public List<Consulta> getConsultas() {
        return new ArrayList<>(consultas);
    }
}