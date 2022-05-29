package ru.smaliav.fiks.infrastructure.persistence.domain.fiks.progress

import org.springframework.stereotype.Repository
import ru.smaliav.fiks.infrastructure.integration.exception.EntityNotFoundException
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

// TODO Унаследоваться от BaseDao (внимание на EntityManager)
@Repository
class VoteProgressDao /*: BaseDao<VoteProgressEntity>() */ {

    @PersistenceContext
    protected lateinit var em: EntityManager

    fun getById(id: Int): VoteProgressEntity {
        val query = em.createQuery(
            "SELECT t FROM VoteProgressEntity t WHERE t.id = :id",
            VoteProgressEntity::class.java
        )
        query.setParameter("id", id)

        val res = query.resultList
        return if (res.isNotEmpty()) {
            res.first()
        } else {
            throw EntityNotFoundException(VoteProgressEntity::class, id)
        }
    }

    fun saveOrUpdate(entity: VoteProgressEntity): VoteProgressEntity {
        return if (entity.id == null) {
            em.persist(entity)
            entity
        } else {
            em.merge(entity)
        }
    }

}
