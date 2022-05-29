package ru.smaliav.fiks.domain.fiks.progress

import ru.smaliav.fiks.common.`object`.AggregateRoot
import ru.smaliav.fiks.common.`object`.IntegerEntityId

class VotePoll: AggregateRoot<VotePoll.Id>() {

    var voted = 0
    var agreed = 0
    var rejected = 0

    inner class Id(id: Int): IntegerEntityId(id)
}
