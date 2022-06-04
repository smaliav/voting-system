package ru.smaliav.voting.infrastructure.integration.vote.chat

import org.springframework.stereotype.Component
import ru.smaliav.voting.domain.user.User
import ru.smaliav.voting.domain.vote.chat.VoteChat
import ru.smaliav.voting.domain.vote.chat.VoteChatMessage
import ru.smaliav.voting.infrastructure.integration.base.converter.DtoToBusinessConverter
import ru.smaliav.voting.infrastructure.integration.exception.InvalidNullException

@Component
class VoteChatMessageDtoConverter : DtoToBusinessConverter<VoteChatMessageDto, VoteChatMessage> {

    override fun dto2b(dto: VoteChatMessageDto): VoteChatMessage {
        return VoteChatMessage(
            VoteChat.Id(dto.chatId),
            User.Id(dto.userId),
            dto.content,
            dto.sent,
        )
    }

    override fun b2dto(business: VoteChatMessage): VoteChatMessageDto {
        return VoteChatMessageDto(
            business.id?.value ?: throw InvalidNullException(),
            business.userId.value ?: throw InvalidNullException(),
            business.content,
            business.sent
        )
    }

}