package br.com.ifba.usuario.repository;

import br.com.ifba.infra.jpa.JPAUtil;
import br.com.ifba.usuario.entity.Usuario;
import jakarta.persistence.EntityManager;
import java.util.List;

public class RepositorioUsuarioJPA {

    // Salva um novo usuário no banco de dados
    public void salvar(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    // Busca um usuário pelo ID
    public Usuario buscarPorId(Long id) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            return em.find(Usuario.class, id);
        }
    }

    // Busca um usuário pelo e-mail
    public Usuario buscarPorEmail(String email) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            return em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.email = :email",
                    Usuario.class
            )
            .setParameter("email", email)
            .getResultStream()
            .findFirst()
            .orElse(null);
        }
    }

    // Lista todos os usuários cadastrados
    public List<Usuario> listarTodos() {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            return em.createQuery(
                    "SELECT u FROM Usuario u",
                    Usuario.class
            ).getResultList();
        }
    }

    // Exclui um usuário pelo ID
    public void excluir(Long id) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Usuario usuario = em.find(Usuario.class, id);

            if (usuario != null) {
                em.remove(usuario);
            }

            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
}
