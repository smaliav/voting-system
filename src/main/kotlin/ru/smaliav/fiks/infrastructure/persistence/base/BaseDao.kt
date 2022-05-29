package ru.smaliav.fiks.infrastructure.persistence.base

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

// TODO Реализовать до конца (не инжектится EntityManager)
abstract class BaseDao<E : EntityWithId> {

    @PersistenceContext protected lateinit var em: EntityManager

    fun saveOrUpdate(entity: E): E {
        return if (entity.id == null) {
            em.persist(entity)
            entity
        } else {
            em.merge(entity)
        }
    }

}
