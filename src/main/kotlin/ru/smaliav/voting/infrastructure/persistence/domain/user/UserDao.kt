package ru.smaliav.voting.infrastructure.persistence.domain.user

import org.springframework.stereotype.Repository
import ru.smaliav.voting.infrastructure.integration.exception.EntityNotFoundException
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class UserDao(
    @PersistenceContext
    private val em: EntityManager,
) {

    fun getById(id: Int): UserEntity {
        val query = em.createQuery(
            "SELECT t FROM UserEntity t WHERE t.id = :id",
            UserEntity::class.java
        )
        query.setParameter("id", id)

        val res = query.resultList
        return if (res.isNotEmpty()) {
            res.first()
        } else {
            throw EntityNotFoundException(UserEntity::class, id)
        }
    }

}