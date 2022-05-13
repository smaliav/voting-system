package ru.smaliav.fiks.infrastructure.persistence.domain.fiks

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class FiksDao @Autowired constructor(
    @PersistenceContext
    private val em: EntityManager,
) {

    fun getById(id: Int): FiksEntity? {
        val query = em.createQuery(
            "SELECT t FROM FiksEntity t WHERE t.id = :id",
            FiksEntity::class.java
        )
        query.setParameter("id", id)

        val res = query.resultList
        return if (res.isNotEmpty()) res.first() else null
    }

    fun saveOrUpdate(entity: FiksEntity): FiksEntity {
        return if (entity.id == null) {
            em.persist(entity)
            entity;
        } else {
            em.merge(entity)
        }
    }

}