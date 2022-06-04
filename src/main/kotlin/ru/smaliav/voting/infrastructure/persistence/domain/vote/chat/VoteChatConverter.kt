package ru.smaliav.voting.infrastructure.persistence.domain.vote.chat

import org.springframework.stereotype.Component
import ru.smaliav.voting.domain.vote.chat.VoteChat
import ru.smaliav.voting.infrastructure.integration.exception.InvalidNullException

// TODO Реализовать интерфейс BusinessToEntityConverter
@Component
class VoteChatConverter(
    private val chatDao: VoteChatDao,
) {

    fun b2e(business: VoteChat): VoteChatEntity {
        return VoteChatEntity(
            business.id?.value,
            business.name,
        )
    }

    fun bid2e(businessId: VoteChat.Id): VoteChatEntity {
        val bid = businessId.value ?: throw InvalidNullException()
        return chatDao.getById(bid)
    }

    fun e2b(entity: VoteChatEntity): VoteChat {
        val business = VoteChat(
            entity.name,
        )
        business.id = VoteChat.Id(entity.id!!) // TODO Обратить на это внимание

        return business
    }

    fun e2bid(entity: VoteChatEntity): VoteChat.Id {
        return VoteChat.Id(entity.id!!) // TODO Обратить на это внимание
    }

}