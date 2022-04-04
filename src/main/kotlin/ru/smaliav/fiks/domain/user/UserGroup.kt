package ru.smaliav.fiks.domain.user

import ru.smaliav.fiks.common.`object`.AggregateRoot
import ru.smaliav.fiks.common.`object`.IntegerEntityId
import ru.smaliav.fiks.domain.fiks.Fiks

class UserGroup(
    val name: String,
    val users: List<User>,
    val fikses: List<Fiks>,
): AggregateRoot<UserGroup.Id>() {

    inner class Id: IntegerEntityId()
}
