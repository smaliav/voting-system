package ru.smaliav.voting.infrastructure.persistence.domain.vote.chat.message

import org.springframework.stereotype.Component
import ru.smaliav.voting.domain.vote.chat.VoteChatMessage
import ru.smaliav.voting.infrastructure.persistence.base.converter.BusinessToEntityConverter
import ru.smaliav.voting.infrastructure.persistence.base.converter.exception.BusinessIdToEntityConversionException
import ru.smaliav.voting.infrastructure.persistence.base.converter.exception.EntityToBusinessIdConversionException
import ru.smaliav.voting.infrastructure.persistence.domain.user.UserConverter
import ru.smaliav.voting.infrastructure.persistence.domain.vote.chat.VoteChatConverter

@Component
class VoteChatMessageConverter(
    private val chatConverter: VoteChatConverter,
    private val userConverter: UserConverter,
    private val messageDao: VoteChatMessageDao,
) : BusinessToEntityConverter<VoteChatMessage, VoteChatMessage.Id, VoteChatMessageEntity> {

    override fun b2e(business: VoteChatMessage): VoteChatMessageEntity {
        return VoteChatMessageEntity(
            business.id?.value,
            chatConverter.bid2e(business.chatId),
            userConverter.bid2e(business.userId),
            business.content,
            business.sent,
        )
    }

    override fun e2b(entity: VoteChatMessageEntity): VoteChatMessage {
        val business = VoteChatMessage(
            chatConverter.e2bid(entity.chat),
            userConverter.e2bid(entity.user),
            entity.content,
            entity.sent,
        )
        business.id = e2bid(entity)
        return business
    }

    override fun e2bid(entity: VoteChatMessageEntity): VoteChatMessage.Id {
        val id = entity.id ?: throw EntityToBusinessIdConversionException(
            VoteChatMessageEntity::class, VoteChatMessage.Id::class
        )
        return VoteChatMessage.Id(id)
    }

    override fun b2eid(business: VoteChatMessage): Int? = business.id?.value

    override fun bid2e(businessId: VoteChatMessage.Id): VoteChatMessageEntity {
        val id = businessId.value ?: throw BusinessIdToEntityConversionException(
            VoteChatMessage.Id::class, VoteChatMessageEntity::class
        )
        return messageDao.getById(id)
    }

}