package ru.smaliav.voting.infrastructure.integration.vote.chat

import org.springframework.stereotype.Service
import ru.smaliav.voting.domain.vote.chat.VoteChatMessage
import ru.smaliav.voting.infrastructure.persistence.domain.vote.chat.message.VoteChatMessageRepository
import javax.transaction.Transactional

@Service
class VoteChatService(
    private val messageConverter: VoteChatMessageDtoConverter,
    private val messageRepo: VoteChatMessageRepository,
) {

    @Transactional
    fun createMessage(messageDto: VoteChatMessageDto): VoteChatMessage {
        val message = messageConverter.dto2b(messageDto)
        return messageRepo.save(message)
    }

}