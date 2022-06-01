package ru.smaliav.voting.infrastructure.persistence.domain.vote.chat.message

import org.springframework.stereotype.Repository
import ru.smaliav.voting.domain.vote.chat.VoteChatMessage

@Repository
class VoteChatMessageRepository(
    private val messageDao: VoteChatMessageDao,
    private val messageConverter: VoteChatMessageConverter,
) {

    fun save(message: VoteChatMessage): VoteChatMessage {
        var entity = messageConverter.b2e(message)
        entity = messageDao.saveOrUpdate(entity)
        return messageConverter.e2b(entity)
    }

}