package ru.smaliav.voting.domain.vote.progress.stage.poll

import ru.smaliav.voting.common.`object`.AggregateRoot
import ru.smaliav.voting.common.`object`.IntegerEntityId

class VotePoll(): AggregateRoot<VotePoll.Id>() {
    var agreed = 0
    var rejected = 0

    constructor(id: Id, agreed: Int, rejected: Int) : this() {
        this.id = id
        this.agreed = agreed
        this.rejected = rejected
    }

    class Id(id: Int): IntegerEntityId(id)
}
