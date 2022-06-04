package ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.stage

import org.springframework.stereotype.Repository
import ru.smaliav.voting.infrastructure.integration.exception.EntityNotFoundException
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class VoteProgressStageDao(
    @PersistenceContext
    private val em: EntityManager,
) {

    fun getById(id: Int): VoteProgressStageEntity {
        val query = em.createQuery(
            "SELECT t FROM VoteProgressStageEntity t WHERE t.id = :id",
            VoteProgressStageEntity::class.java
        )
        query.setParameter("id", id)

        val res = query.resultList
        return if (res.isNotEmpty()) {
            res.first()
        } else {
            throw EntityNotFoundException(VoteProgressStageEntity::class, id)
        }
    }

    fun saveOrUpdate(entity: VoteProgressStageEntity): VoteProgressStageEntity {
        return if (entity.id == null) {
            em.persist(entity)
            entity
        } else {
            em.merge(entity)
        }
    }

}