package ru.smaliav.voting.domain.vote.progress

import ru.smaliav.voting.common.`object`.AggregateRoot
import ru.smaliav.voting.common.`object`.IntegerEntityId

class VotePoll: AggregateRoot<VotePoll.Id>() {

    var voted = 0
    var agreed = 0
    var rejected = 0

    inner class Id(id: Int): IntegerEntityId(id)
}
