/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infra.jpa.JPAUtil;
import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

/**
 *
 * @author gabri
 */
public class GenericDao<Entity extends PersistenceEntity>
        implements GenericIDao<Entity> {

    private final Class<Entity> tipo;

    public GenericDao(Class<Entity> tipo) {
        this.tipo = tipo;
    }

    @Override
    public Entity save(Entity entity) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transacao = em.getTransaction();

        try {
            transacao.begin();
            em.persist(entity);
            transacao.commit();
            return entity;

        } catch (Exception e) {
            if (transacao.isActive()) {
                transacao.rollback();
            }
            throw new DaoException("Erro ao salvar entidade.", e);

        } finally {
            em.close();
        }
    }

    @Override
    public Entity update(Entity entity) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transacao = em.getTransaction();

        try {
            transacao.begin();
            Entity atualizada = em.merge(entity);
            transacao.commit();
            return atualizada;

        } catch (Exception e) {
            if (transacao.isActive()) {
                transacao.rollback();
            }
            throw new DaoException("Erro ao atualizar entidade.", e);

        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Entity entity) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transacao = em.getTransaction();

        try {
            transacao.begin();
            Entity gerenciada = em.merge(entity);
            em.remove(gerenciada);
            transacao.commit();

        } catch (Exception e) {
            if (transacao.isActive()) {
                transacao.rollback();
            }
            throw new DaoException("Erro ao excluir entidade.", e);

        } finally {
            em.close();
        }
    }

    @Override
    public Entity findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.find(tipo, id);

        } finally {
            em.close();
        }
    }

    @Override
    public List<Entity> findAll() {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            String jpql = "SELECT e FROM " + tipo.getSimpleName() + " e";
            return em.createQuery(jpql, tipo).getResultList();

        } finally {
            em.close();
        }
    }
}