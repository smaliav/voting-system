package ru.smaliav.voting.infrastructure.persistence.domain.vote.chat

import org.springframework.stereotype.Repository
import ru.smaliav.voting.infrastructure.integration.exception.EntityNotFoundException
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class VoteChatDao(
    @PersistenceContext
    private val em: EntityManager,
) {

    fun getById(id: Int): VoteChatEntity {
        val query = em.createQuery(
            "SELECT t FROM VoteChatEntity t WHERE t.id = :id",
            VoteChatEntity::class.java
        )
        query.setParameter("id", id)

        val res = query.resultList
        return if (res.isNotEmpty()) {
            res.first()
        } else {
            throw EntityNotFoundException(VoteChatEntity::class, id)
        }
    }

    fun saveOrUpdate(entity: VoteChatEntity): VoteChatEntity {
        return if (entity.id == null) {
            em.persist(entity)
            entity;
        } else {
            em.merge(entity)
        }
    }

}