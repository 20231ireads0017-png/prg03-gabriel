/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infra.jpa;

/**
 *
 * @author gabri
 */


import org.flywaydb.core.Flyway;

public class FlywayUtil {

    public static void migrar() {
        String senha = System.getenv("DB_PASSWORD");

        if (senha == null || senha.isBlank()) {
            throw new IllegalStateException(
                "Variável de ambiente DB_PASSWORD não configurada."
            );
        }

        // Aplica as migrations pendentes no MySQL
        Flyway flyway = Flyway.configure()
                .dataSource(
                    "jdbc:mysql://localhost:3306/sistema_sus",
                    "sus_app",
                    senha
                )
                .locations("classpath:db/migration")
                .load();

        flyway.migrate();
    }
}
