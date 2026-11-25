/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.paciente.entity;

import br.com.ifba.consulta.entity.Consulta;
import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
@Entity
@Table(name = "pacientes")
public class Paciente extends PersistenceEntity {

    private String nome;

    @Column(name = "cartao_sus", unique = true)
    private String cartaoSus;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "paciente_id")
    private List<Consulta> consultas = new ArrayList<>();

    protected Paciente() {
    }

    public Paciente(String nome, String cartaoSus) {
        this.nome = nome;
        this.cartaoSus = cartaoSus;
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