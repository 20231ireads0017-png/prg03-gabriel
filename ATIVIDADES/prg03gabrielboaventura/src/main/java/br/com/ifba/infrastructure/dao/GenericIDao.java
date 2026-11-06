/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

/**
 *
 * @author gabri
 */

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import java.util.List;

public interface GenericIDao<Entity extends PersistenceEntity> {

    // Salva uma nova entidade
    Entity save(Entity entity);

    // Atualiza uma entidade existente
    Entity update(Entity entity);

    // Exclui uma entidade
    void delete(Entity entity);

    // Busca uma entidade pelo ID
    Entity findById(Long id);

    // Lista todas as entidades
    List<Entity> findAll();
}

