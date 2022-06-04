package ru.smaliav.voting.infrastructure.integration.vote

import ru.smaliav.voting.infrastructure.integration.vote.progress.VoteProgressDto

/**
 * DTO голосования (предложения)
 */
data class VoteDto(
    val id: Int,
    val name: String,
    val description: String,
    val expires: Long,
    val progress: VoteProgressDto,
)
