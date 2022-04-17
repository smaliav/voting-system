package ru.smaliav.fiks.infrastructure.integration.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.smaliav.fiks.domain.user.UserGroupType
import ru.smaliav.fiks.infrastructure.integration.user.`interface`.IUserRepository

@Service
class UserService(
    @Autowired private val userRepo: IUserRepository,
) {
    fun getUserGroup(groupType: UserGroupType) = userRepo.getUserGroupByType(groupType)
}
