package ru.smaliav.voting.infrastructure.integration.vote

data class VoteDto(
    var name: String,
    var expires: Long,
    var targetId: Int,
    var description: String,
)
