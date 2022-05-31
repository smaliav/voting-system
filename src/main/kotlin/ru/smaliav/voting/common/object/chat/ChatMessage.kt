package ru.smaliav.voting.common.`object`.chat

import ru.smaliav.voting.common.`object`.AggregateRoot
import ru.smaliav.voting.common.`object`.IntegerEntityId
import ru.smaliav.voting.domain.user.User
import java.time.Instant

class ChatMessage(val sender: User, val content: String): AggregateRoot<ChatMessage.Id>() {

    private val sent = Instant.now()
    private var state = ChatMessageState.SENT

    inner class Id(id: Int): IntegerEntityId(id)
}
