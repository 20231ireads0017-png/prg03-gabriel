/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infra.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author gabri
 */
public class JPAUtil {

    private static final EntityManagerFactory FACTORY = criarFactory();

    private static EntityManagerFactory criarFactory() {
        Properties config = new Properties();

        try (InputStream arquivo = JPAUtil.class.getClassLoader()
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

        String senha = System.getenv("DB_PASSWORD");

        if (senha == null || senha.isBlank()) {
            throw new IllegalStateException(
                    "Variável de ambiente DB_PASSWORD não configurada.");
        }

        Map<String, Object> propriedades = new HashMap<>();

        propriedades.put("jakarta.persistence.jdbc.driver",
                config.getProperty("spring.datasource.driver-class-name"));

        propriedades.put("jakarta.persistence.jdbc.url",
                config.getProperty("spring.datasource.url"));

        propriedades.put("jakarta.persistence.jdbc.user",
                config.getProperty("spring.datasource.username"));

        propriedades.put("jakarta.persistence.jdbc.password", senha);

        propriedades.put("hibernate.dialect",
                config.getProperty("spring.jpa.database-platform"));

        propriedades.put("hibernate.hbm2ddl.auto",
                config.getProperty("spring.jpa.hibernate.ddl-auto"));

        propriedades.put("hibernate.show_sql",
                config.getProperty("spring.jpa.show-sql"));

        return Persistence.createEntityManagerFactory(
                "sistema_sus", propriedades);
    }

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

    public static void fechar() {
        if (FACTORY.isOpen()) {
            FACTORY.close();
        }
    }
}
