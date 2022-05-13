package ru.smaliav.fiks.infrastructure.persistence.domain.fiks.trg

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class FiksTargetDao @Autowired constructor(
    @PersistenceContext private val em: EntityManager,
) {

    fun getById(id: Int): FiksTargetEntity? {
        val query = em.createQuery(
            "SELECT t FROM FiksTargetEntity t WHERE t.id = :id",
            FiksTargetEntity::class.java
        )
        query.setParameter("id", id)

        val res = query.resultList
        return if (res.isNotEmpty()) res.first() else null
    }

}