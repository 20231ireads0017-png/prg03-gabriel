/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.usuario.dao;

/**
 *
 * @author gabri
 */

import br.com.ifba.infrastructure.dao.GenericIDao;
import br.com.ifba.usuario.entity.Usuario;
import java.util.List;

public interface UsuarioIDao extends GenericIDao<Usuario> {

    // Busca um usuário pelo e-mail
    Usuario findByEmail(String email);
    List<Usuario> pesquisar(String texto);
}

