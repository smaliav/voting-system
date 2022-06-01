package ru.smaliav.voting.infrastructure.integration.vote.chat

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.smaliav.voting.domain.vote.chat.VoteChatMessage

@RequestMapping("/chat")
@RestController
class VoteChatController(
    private val chatService: VoteChatService,
) {

    @PostMapping("/message")
    fun createChatMessage(@RequestBody messageDto: VoteChatMessageDto): VoteChatMessage {
        return chatService.createMessage(messageDto)
    }

}