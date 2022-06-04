package ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.stage.poll

import org.springframework.stereotype.Repository
import ru.smaliav.voting.infrastructure.integration.exception.EntityNotFoundException
import javax.persistence.EntityManager

@Repository
class VotePollDao(
    private val em: EntityManager,
) {

    fun getById(id: Int): VotePollEntity {
        val query = em.createQuery(
            "SELECT t FROM VotePollEntity t WHERE t.id = :id",
            VotePollEntity::class.java
        )
        query.setParameter("id", id)

        val res = query.resultList
        return if (res.isNotEmpty()) {
            res.first()
        } else {
            throw EntityNotFoundException(VotePollEntity::class, id)
        }
    }

    fun saveOrUpdate(entity: VotePollEntity): VotePollEntity {
        return if (entity.id == null) {
            em.persist(entity)
            entity
        } else {
            em.merge(entity)
        }
    }

}