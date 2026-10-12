/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.com.ifba.usuario.entity;

import br.com.ifba.usuario.interfaces.Autenticavel;
import br.com.ifba.paciente.entity.Paciente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.Objects;

/**
 *
 * @author gabri
 */

@Entity
@Table(name = "usuarios")

public class Usuario implements Autenticavel {

    // Identificador único do usuário no banco de dados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Dados do usuário
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    // Relacionamento ainda não persistido no banco
    @Transient
    private Paciente paciente;

    // Construtor vazio exigido pela JPA
    public Usuario() {
    }

    // Construtor com os dados do usuário
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // Métodos de acesso do ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    // O e-mail identifica o usuário no sistema e funciona como seu login
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }

        if (!(objeto instanceof Usuario)) {
            return false;
        }

        Usuario usuario = (Usuario) objeto;
        return Objects.equals(this.email, usuario.email);
    }

    // Gera o código de comparação usando o mesmo campo do equals
    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
