package ru.smaliav.fiks.domain.fiks.chat

import ru.smaliav.fiks.common.`object`.AggregateRoot
import ru.smaliav.fiks.common.`object`.IntegerEntityId

class VoteChat(val name: String): AggregateRoot<VoteChat.Id>() {

    inner class Id(id: Int): IntegerEntityId(id)
}
