package ru.smaliav.voting.infrastructure.integration.vote.progress

import ru.smaliav.voting.domain.vote.progress.VoteProgressState
import ru.smaliav.voting.infrastructure.integration.vote.progress.stage.VoteProgressStageDto

/**
 * DTO прогресса голосования (предложения)
 */
data class VoteProgressDto(
    val state: VoteProgressState,
    val groupStage: VoteProgressStageDto,
    val expertStage: VoteProgressStageDto?,
    val publicStage: VoteProgressStageDto?,
)
