/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.usuario.controller;

/**
 *
 * @author gabri
 */
import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.service.UsuarioIService;
import java.util.List;

public class UsuarioController implements UsuarioIController {

    private final UsuarioIService service;

    // Recebe o Service pelo construtor, sem criar sua implementação.
    public UsuarioController(UsuarioIService service) {
        this.service = service;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return service.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return service.update(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        service.delete(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        return service.findById(id);
    }

    @Override
    public List<Usuario> findAll() {
        return service.findAll();
    }

    @Override
    public Usuario findByEmail(String email) {
        return service.findByEmail(email);
    }

    @Override
    public boolean autenticar(String email, String senha) {
        return service.autenticar(email, senha);
    }

    @Override
    public List<Usuario> pesquisar(String texto) {
        return service.pesquisar(texto);
    }
}
