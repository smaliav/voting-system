package ru.smaliav.voting.domain.vote.chat

import ru.smaliav.voting.common.`object`.AggregateRoot
import ru.smaliav.voting.common.`object`.IntegerEntityId

class VoteChat(val name: String): AggregateRoot<VoteChat.Id>() {

    inner class Id(id: Int): IntegerEntityId(id)
}
