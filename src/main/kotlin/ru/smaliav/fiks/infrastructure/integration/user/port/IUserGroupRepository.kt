package ru.smaliav.fiks.infrastructure.integration.user.port

import ru.smaliav.fiks.domain.user.UserGroup
import ru.smaliav.fiks.domain.user.UserGroupType

interface IUserGroupRepository {
    fun getUserGroupByType(groupType: UserGroupType): UserGroup?
}
