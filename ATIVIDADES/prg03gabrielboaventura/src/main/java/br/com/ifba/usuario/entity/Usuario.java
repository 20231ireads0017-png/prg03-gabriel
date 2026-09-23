/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;

import br.com.ifba.usuario.interfaces.Autenticavel;
import br.com.ifba.paciente.entity.Paciente;

/**
 *
 * @author gabri
 */
public class Usuario implements Autenticavel {
    
    // Dados do usuário
    private String nome;
    private String email;
    private String senha;
    private Paciente paciente;
    
    // Construtor vazio
    public Usuario() {
    }

    // Construtor com os dados do usuário
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    // Métodos de acesso do nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Métodos de acesso do e-mail
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Métodos de acesso da senha
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    // Retorna o paciente relacionado ao usuário
    public Paciente getPaciente() {
        return paciente;
    }

    // Define o paciente relacionado ao usuário
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    // Verifica se o e-mail e a senha estão corretos
    @Override
    public boolean autenticar(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }

}
