package br.com.ifba.infra.jpa;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JPAUtilTest {

    @Test
    public void deveConectarAoBancoDeDados() {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            assertTrue(em.isOpen());
            System.out.println("Conexão com MySQL realizada com sucesso!");
        }
    }
}
