package ru.smaliav.voting.infrastructure.integration.vote.chat

import java.time.Instant

// TODO Исправить javadoc, почему-то не создается нормальная ссылка на класс
/**
 * DTO объект для класса VoteChatMessage
 */
data class VoteChatMessageDto(
    val chatId: Int,
    val userId: Int,
    val content: String,
    val sent: Instant,
)