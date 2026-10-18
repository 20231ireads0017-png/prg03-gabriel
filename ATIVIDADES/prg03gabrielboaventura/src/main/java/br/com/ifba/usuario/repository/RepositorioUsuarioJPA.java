package br.com.ifba.usuario.repository;

import br.com.ifba.infra.jpa.JPAUtil;
import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.exception.UsuarioNaoEncontradoException;
import jakarta.persistence.EntityManager;
import java.util.List;

public class RepositorioUsuarioJPA {

    // Cadastra um novo usuário no banco de dados
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
        EntityManager em = JPAUtil.getEntityManager();

        try {
            Usuario usuario = em.find(Usuario.class, id);

            if (usuario == null) {
                throw new UsuarioNaoEncontradoException(id);
            }

            return usuario;

        } finally {
            em.close();
        }
    }

    // Busca um usuário pelo e-mail utilizando JPQL
    public Usuario buscarPorEmail(String email) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.email = :email",
                    Usuario.class
            )
            .setParameter("email", email)
            .getResultStream()
            .findFirst()
            .orElse(null);

        } finally {
            em.close();
        }
    }

    // Lista todos os usuários cadastrados
    public List<Usuario> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.createQuery(
                    "SELECT u FROM Usuario u",
                    Usuario.class
            ).getResultList();

        } finally {
            em.close();
        }
    }

    // Exclui um usuário pelo ID
    public void excluir(Long id) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Usuario usuario = em.find(Usuario.class, id);

            // Impede a exclusão de um usuário inexistente
            if (usuario == null) {
                throw new UsuarioNaoEncontradoException(id);
            }

            em.remove(usuario);
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

    // Atualiza um usuário existente no banco de dados
    public void atualizar(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            // Verifica se o usuário existe antes de atualizar
            Usuario existente = em.find(Usuario.class, usuario.getId());

            if (existente == null) {
                throw new UsuarioNaoEncontradoException(usuario.getId());
            }

            em.merge(usuario);
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
    
    // Pesquisa usuários pelo nome ou e-mail utilizando JPQL
    public List<Usuario> pesquisar(String texto) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.createQuery(
                "SELECT u FROM Usuario u "
                + "WHERE LOWER(u.nome) LIKE :texto "
                + "OR LOWER(u.email) LIKE :texto",
                Usuario.class
            )
            .setParameter("texto", "%" + texto.toLowerCase() + "%")
            .getResultList();

        } finally {
            em.close();
         }
    }
}