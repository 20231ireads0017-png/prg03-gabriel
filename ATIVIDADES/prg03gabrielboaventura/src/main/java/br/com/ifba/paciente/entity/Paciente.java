/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.paciente.entity;

/**
 *
 * @author gabri
 */

import br.com.ifba.consulta.entity.Consulta;
import java.util.ArrayList;
import java.util.List;

public class Paciente {

    // Dados do paciente
    private String nome;
    private String cartaoSus;

    // Lista de consultas relacionadas ao paciente
    private List<Consulta> consultas;

    // Cria um paciente com uma lista de consultas vazia
    public Paciente(String nome, String cartaoSus) {
        this.nome = nome;
        this.cartaoSus = cartaoSus;
        this.consultas = new ArrayList<>();
    }

    // Adiciona uma nova consulta ao paciente
    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    // Retorna o nome do paciente
    public String getNome() {
        return nome;
    }

    // Altera o nome do paciente
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Retorna o cartão do SUS
    public String getCartaoSus() {
        return cartaoSus;
    }

    // Altera o cartão do SUS
    public void setCartaoSus(String cartaoSus) {
        this.cartaoSus = cartaoSus;
    }

    // Retorna uma cópia da lista de consultas
    public List<Consulta> getConsultas() {
        return new ArrayList<>(consultas);
    }
}