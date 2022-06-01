package ru.smaliav.voting.infrastructure.persistence.domain.vote.chat.message

import org.springframework.stereotype.Repository
import ru.smaliav.voting.infrastructure.integration.exception.EntityNotFoundException
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class VoteChatMessageDao(
    @PersistenceContext
    private val em: EntityManager,
) {

    fun getById(id: Int): VoteChatMessageEntity {
        val query = em.createQuery(
            "SELECT t FROM VoteChatMessageEntity t WHERE t.id = :id",
            VoteChatMessageEntity::class.java
        )
        query.setParameter("id", id)

        val res = query.resultList
        return if (res.isNotEmpty()) {
            res.first()
        } else {
            throw EntityNotFoundException(VoteChatMessageEntity::class, id)
        }
    }

    fun saveOrUpdate(entity: VoteChatMessageEntity): VoteChatMessageEntity {
        return if (entity.id == null) {
            em.persist(entity)
            entity;
        } else {
            em.merge(entity)
        }
    }

}