package ru.smaliav.fiks.infrastructure.integration.user.`interface`

import org.springframework.stereotype.Repository
import ru.smaliav.fiks.domain.user.UserGroup
import ru.smaliav.fiks.domain.user.UserGroupType

@Repository
interface IUserRepository {
    fun getUserGroupByType(groupType: UserGroupType): UserGroup
}
