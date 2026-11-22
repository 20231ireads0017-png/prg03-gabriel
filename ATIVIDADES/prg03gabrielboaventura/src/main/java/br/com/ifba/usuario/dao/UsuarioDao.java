/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.dao;

import br.com.ifba.infra.jpa.JPAUtil;
import br.com.ifba.infrastructure.dao.GenericDao;
import br.com.ifba.usuario.entity.Usuario;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gabri
 */
@Repository
public class UsuarioDao extends GenericDao<Usuario>
        implements UsuarioIDao {

    public UsuarioDao() {
        super(Usuario.class);
    }

    @Override
    public Usuario findByEmail(String email) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            List<Usuario> usuarios = em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.email = :email",
                    Usuario.class)
                    .setParameter("email", email)
                    .getResultList();

            return usuarios.isEmpty() ? null : usuarios.get(0);

        } finally {
            em.close();
        }
    }

    @Override
    public List<Usuario> pesquisar(String texto) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.createQuery(
                    "SELECT u FROM Usuario u "
                    + "WHERE LOWER(u.nome) LIKE :texto "
                    + "OR LOWER(u.email) LIKE :texto",
                    Usuario.class)
                    .setParameter("texto", "%" + texto.toLowerCase() + "%")
                    .getResultList();
        } finally {
            em.close();
        }
    }
}