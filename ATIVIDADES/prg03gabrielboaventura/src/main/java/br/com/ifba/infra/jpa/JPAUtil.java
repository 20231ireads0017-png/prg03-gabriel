package br.com.ifba.infra.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class JPAUtil {

    private static final EntityManagerFactory FACTORY = criarFactory();

    private static EntityManagerFactory criarFactory() {
        String senha = System.getenv("DB_PASSWORD");

        if (senha == null || senha.isBlank()) {
            throw new IllegalStateException(
                "Variável de ambiente DB_PASSWORD não configurada."
            );
        }

        Map<String, Object> propriedades = new HashMap<>();
        propriedades.put("jakarta.persistence.jdbc.password", senha);

        return Persistence.createEntityManagerFactory(
            "sistema_sus", propriedades
        );
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