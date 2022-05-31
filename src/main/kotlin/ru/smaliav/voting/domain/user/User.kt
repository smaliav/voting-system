package ru.smaliav.voting.domain.user

import ru.smaliav.voting.common.`object`.AggregateRoot
import ru.smaliav.voting.common.`object`.IntegerEntityId

class User(
    val nickname: String,
    val roles: List<UserRole>,
    val account: Account,
): AggregateRoot<User.Id>() {

    inner class Id(id: Int): IntegerEntityId(id)
}
