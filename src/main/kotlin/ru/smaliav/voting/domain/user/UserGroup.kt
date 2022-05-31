package ru.smaliav.voting.domain.user

import ru.smaliav.voting.common.`object`.AggregateRoot
import ru.smaliav.voting.common.`object`.IntegerEntityId

class UserGroup(
    val name: String,
    val type: UserGroupType,
    // TODO Участники группы
    // val userIds: List<User.Id>,
    // TODO Голосования группы
    // val voteIds: List<Vote.Id>,
): AggregateRoot<UserGroup.Id>() {

    inner class Id(id: Int): IntegerEntityId(id)
}
