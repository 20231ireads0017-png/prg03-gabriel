/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infra.jpa;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.flywaydb.core.Flyway;

/**
 *
 * @author gabri
 */
public class FlywayUtil {

    public static void migrar() {

        // Carrega as configurações do banco de dados centralizadas
        // no application.properties, evitando duplicação no código.
        Properties config = new Properties();

        try (InputStream arquivo = FlywayUtil.class.getClassLoader()
                .getResourceAsStream("application.properties")) {

            if (arquivo == null) {
                throw new IllegalStateException(
                        "Arquivo application.properties não encontrado.");
            }

            config.load(arquivo);

        } catch (IOException e) {
            throw new IllegalStateException(
                    "Erro ao ler application.properties.", e);
        }

        // Obtém a senha pela variável de ambiente para evitar
        // a exposição de credenciais no código-fonte e no GitHub.
        String senha = System.getenv("DB_PASSWORD");

        if (senha == null || senha.isBlank()) {
            throw new IllegalStateException(
                    "Variável de ambiente DB_PASSWORD não configurada."
            );
        }

        Flyway flyway = Flyway.configure()
                .dataSource(
                        config.getProperty("spring.datasource.url"),
                        config.getProperty("spring.datasource.username"),
                        senha
                )
                .locations("classpath:db/migration")
                .load();
        flyway.migrate();
    }
}