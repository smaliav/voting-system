package ru.smaliav.fiks.domain.user

import ru.smaliav.fiks.common.`object`.AggregateRoot
import ru.smaliav.fiks.common.`object`.IntegerEntityId

class User(
    val nickname: String,
    val roles: List<UserRole>,
    val account: Account,
): AggregateRoot<User.Id>() {

    inner class Id(id: Int): IntegerEntityId(id)
}
