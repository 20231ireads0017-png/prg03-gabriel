/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.dao;

/**
 *
 * @author gabri
 */

import br.com.ifba.infra.jpa.JPAUtil;
import br.com.ifba.infrastructure.dao.GenericDao;
import br.com.ifba.usuario.entity.Usuario;
import jakarta.persistence.EntityManager;
import java.util.List;

public class UsuarioDao extends GenericDao<Usuario>
        implements UsuarioIDao {

    // Informa ao DAO qual entidade será utilizada
    public UsuarioDao() {
        super(Usuario.class);
    }

    // Busca um usuário pelo e-mail
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
