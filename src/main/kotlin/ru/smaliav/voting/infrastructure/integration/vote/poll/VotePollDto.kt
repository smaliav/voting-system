package ru.smaliav.voting.infrastructure.integration.vote.poll

/**
 * Опрос внутри этапа голосования
 */
data class VotePollDto(
    val id: Int,
    val agreed: Int,
    val rejected: Int,
)
