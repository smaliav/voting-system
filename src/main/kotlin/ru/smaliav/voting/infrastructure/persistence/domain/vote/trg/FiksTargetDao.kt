package ru.smaliav.voting.infrastructure.persistence.domain.vote.trg

import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class FiksTargetDao(
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