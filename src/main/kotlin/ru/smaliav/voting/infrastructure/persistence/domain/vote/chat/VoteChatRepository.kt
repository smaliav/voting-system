package ru.smaliav.voting.infrastructure.persistence.domain.vote.chat

import org.springframework.stereotype.Repository
import ru.smaliav.voting.domain.vote.chat.VoteChat

@Repository
class VoteChatRepository(
    private val chatDao: VoteChatDao,
    private val chatConverter: VoteChatConverter,
) {

    fun save(chat: VoteChat): VoteChat {
        var entity = chatConverter.b2e(chat)
        entity = chatDao.saveOrUpdate(entity)
        return chatConverter.e2b(entity)
    }

}