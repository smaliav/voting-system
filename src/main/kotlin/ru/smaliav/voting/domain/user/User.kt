package ru.smaliav.voting.domain.user

import ru.smaliav.voting.common.`object`.AggregateRoot
import ru.smaliav.voting.common.`object`.IntegerEntityId

class User(
    val nickname: String,
    // TODO Роли
    // val roles: List<UserRole>,
    // TODO Счет
    // val account: Account,
): AggregateRoot<User.Id>() {

    class Id(id: Int): IntegerEntityId(id)
}
