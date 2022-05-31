package ru.smaliav.voting.infrastructure.persistence.domain.vote

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

// TODO Унаследоваться от BaseDao (внимание на EntityManager)
@Repository
class VoteDao @Autowired constructor(
    @PersistenceContext
    private val em: EntityManager,
) {

    fun getById(id: Int): VoteEntity? {
        val query = em.createQuery(
            "SELECT t FROM VoteEntity t WHERE t.id = :id",
            VoteEntity::class.java
        )
        query.setParameter("id", id)

        val res = query.resultList
        return if (res.isNotEmpty()) res.first() else null
    }

    fun saveOrUpdate(entity: VoteEntity): VoteEntity {
        return if (entity.id == null) {
            em.persist(entity)
            entity;
        } else {
            em.merge(entity)
        }
    }

}