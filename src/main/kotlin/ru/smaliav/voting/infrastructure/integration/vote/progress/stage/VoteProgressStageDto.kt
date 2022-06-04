package ru.smaliav.voting.infrastructure.integration.vote.progress.stage

import ru.smaliav.voting.domain.vote.progress.stage.VoteProgressStageType
import ru.smaliav.voting.infrastructure.integration.vote.poll.VotePollDto

/**
 * DTO этапа голосования (предложения)
 */
data class VoteProgressStageDto(
    val type: VoteProgressStageType,
    val poll: VotePollDto,
)
