/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atendimento.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.MappedSuperclass;

/**
 *
 * @author gabri
 */
@MappedSuperclass
public abstract class Atendimento extends PersistenceEntity {

    private String especialidade;
    private String data;

    protected Atendimento() {
    }

    public Atendimento(String especialidade, String data) {
        this.especialidade = especialidade;
        this.data = data;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public abstract String getTipoAtendimento();
}