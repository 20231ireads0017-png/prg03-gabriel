/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prg03gabrielboaventura;

import br.com.ifba.login.view.TelaLogin;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {
    "com.mycompany.prg03gabrielboaventura",
    "br.com.ifba"
})

/**
 *
 * @author gabri
 */
public class ProjetoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context
                = new SpringApplicationBuilder(ProjetoApplication.class)
                        .headless(false)
                        .run(args);

        TelaLogin tela = context.getBean(TelaLogin.class);
        tela.setVisible(true);
    }
}