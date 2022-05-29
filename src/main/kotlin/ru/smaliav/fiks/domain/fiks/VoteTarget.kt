package ru.smaliav.fiks.domain.fiks

import ru.smaliav.fiks.common.`object`.AggregateRoot
import ru.smaliav.fiks.common.`object`.IntegerEntityId

class VoteTarget(
    val name: String,
    val code: String,
): AggregateRoot<VoteTarget.Id>() {

    class Id(id: Int): IntegerEntityId(id)
}
