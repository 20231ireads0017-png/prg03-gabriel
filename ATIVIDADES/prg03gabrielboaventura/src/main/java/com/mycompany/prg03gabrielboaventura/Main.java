/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prg03gabrielboaventura;

import br.com.ifba.login.view.TelaLogin;
import br.com.ifba.usuario.controller.UsuarioController;
import br.com.ifba.usuario.controller.UsuarioIController;
import br.com.ifba.usuario.dao.UsuarioDao;
import br.com.ifba.usuario.dao.UsuarioIDao;
import br.com.ifba.usuario.service.UsuarioIService;
import br.com.ifba.usuario.service.UsuarioService;

/**
 *
 * @author gabri
 */
public class Main {

    public static void main(String[] args) {

        UsuarioIDao dao = new UsuarioDao();
        UsuarioIService service = new UsuarioService(dao);
        UsuarioIController controller = new UsuarioController(service);

        java.awt.EventQueue.invokeLater(() ->
                new TelaLogin(controller).setVisible(true)
        );
    }
}