package ru.smaliav.fiks.domain.user

import ru.smaliav.fiks.common.`object`.AggregateRoot
import ru.smaliav.fiks.common.`object`.IntegerEntityId
import ru.smaliav.fiks.domain.fiks.Fiks

class UserGroup(
    val name: String,
    val type: UserGroupType,
    // TODO Участники группы
    // val userIds: List<User.Id>,
    // TODO ФИКСы группы
    // val fiksIds: List<Fiks.Id>,
): AggregateRoot<UserGroup.Id>() {

    inner class Id(id: Int): IntegerEntityId(id)
}
