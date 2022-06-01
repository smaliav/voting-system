package ru.smaliav.voting.domain.vote.chat

import ru.smaliav.voting.common.`object`.AggregateRoot
import ru.smaliav.voting.common.`object`.IntegerEntityId
import ru.smaliav.voting.domain.user.User
import java.time.Instant

/**
 * Сообщение в чате голосования
 */
class VoteChatMessage(
    val chatId: VoteChat.Id,
    val userId: User.Id,
    val content: String,
    val sent: Instant,
) : AggregateRoot<VoteChatMessage.Id>() {

    class Id(id: Int) : IntegerEntityId(id)
}