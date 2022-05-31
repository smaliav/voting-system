package ru.smaliav.voting.infrastructure.integration.user.port

import ru.smaliav.voting.domain.user.UserGroup
import ru.smaliav.voting.domain.user.UserGroupType

interface IUserGroupRepository {
    fun getUserGroupByType(groupType: UserGroupType): UserGroup?
}
