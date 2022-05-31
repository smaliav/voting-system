package ru.smaliav.voting.domain.vote.chat

import ru.smaliav.voting.common.`object`.AggregateRoot
import ru.smaliav.voting.common.`object`.IntegerEntityId
import ru.smaliav.voting.common.`object`.chat.ChatMessage

class GroupChat(val name: String): AggregateRoot<GroupChat.Id>() {

    private val messages = listOf<ChatMessage>()

    inner class Id(id: Int): IntegerEntityId(id)
}
