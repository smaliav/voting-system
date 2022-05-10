package ru.smaliav.fiks.infrastructure.persistence.domain.user

import org.springframework.stereotype.Repository
import ru.smaliav.fiks.domain.user.UserGroupType
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class UserGroupDao(
    @PersistenceContext
    private val em: EntityManager
) {

    fun getUserGroupByType(userGroupType: UserGroupType): UserGroupEntity? {
        val query = em.createQuery(
            "SELECT t FROM UserGroupEntity t WHERE t.type = :type ORDER BY t.id ASC",
            UserGroupEntity::class.java
        )
        query.setParameter("type", userGroupType)
        query.maxResults = 1

        val res = query.resultList
        return if (res.isNotEmpty()) res.first() else null
    }

}
