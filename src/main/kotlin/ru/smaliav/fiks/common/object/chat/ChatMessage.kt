package ru.smaliav.fiks.common.`object`.chat

import ru.smaliav.fiks.common.`object`.AggregateRoot
import ru.smaliav.fiks.common.`object`.IntegerEntityId
import ru.smaliav.fiks.domain.user.User
import java.time.Instant

class ChatMessage(val sender: User, val content: String): AggregateRoot<ChatMessage.Id>() {

    private val sent = Instant.now()
    private var state = ChatMessageState.SENT

    inner class Id(id: Int): IntegerEntityId(id)
}
