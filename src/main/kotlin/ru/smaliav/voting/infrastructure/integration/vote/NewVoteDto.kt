package ru.smaliav.voting.infrastructure.integration.vote

/**
 * Предложение (голосование)
 */
data class NewVoteDto(
    var name: String,
    var expires: Long,
    var targetId: Int,
    var description: String,
)
