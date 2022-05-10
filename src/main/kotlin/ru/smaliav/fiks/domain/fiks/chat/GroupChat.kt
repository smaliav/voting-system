package ru.smaliav.fiks.domain.fiks.chat

import ru.smaliav.fiks.common.`object`.AggregateRoot
import ru.smaliav.fiks.common.`object`.IntegerEntityId
import ru.smaliav.fiks.common.`object`.chat.ChatMessage

class GroupChat(val name: String): AggregateRoot<GroupChat.Id>() {

    private val messages = listOf<ChatMessage>()

    inner class Id(id: Int): IntegerEntityId(id)
}
