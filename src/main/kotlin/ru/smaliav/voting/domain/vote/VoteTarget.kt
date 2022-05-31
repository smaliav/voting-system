package ru.smaliav.voting.domain.vote

import ru.smaliav.voting.common.`object`.AggregateRoot
import ru.smaliav.voting.common.`object`.IntegerEntityId

class VoteTarget(
    val name: String,
    val code: String,
): AggregateRoot<VoteTarget.Id>() {

    class Id(id: Int): IntegerEntityId(id)
}
