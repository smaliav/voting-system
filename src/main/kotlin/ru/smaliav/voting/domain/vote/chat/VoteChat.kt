package ru.smaliav.voting.domain.vote.chat

import ru.smaliav.voting.common.`object`.AggregateRoot
import ru.smaliav.voting.common.`object`.IntegerEntityId

class VoteChat(name: String): AggregateRoot<VoteChat.Id>() {
    object Constants {
        const val CHAT_NAME_PREFIX = "Чат голосования: "
    }

    val name = Constants.CHAT_NAME_PREFIX + name

    class Id(id: Int): IntegerEntityId(id)
}
