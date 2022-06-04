package ru.smaliav.voting.infrastructure.integration.vote.progress.stage

import org.springframework.stereotype.Component
import ru.smaliav.voting.domain.vote.progress.stage.VoteProgressStage
import ru.smaliav.voting.infrastructure.integration.exception.InvalidNullException
import ru.smaliav.voting.infrastructure.integration.vote.poll.VotePollDtoConverter
import ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.stage.poll.VotePollRepository

@Component
class VoteProgressStageDtoConverter(
    private val pollRepo: VotePollRepository,
    private val pollConverter: VotePollDtoConverter
) {

    fun b2dto(business: VoteProgressStage): VoteProgressStageDto {
        val poll = pollRepo.getById(business.pollId.value ?: throw InvalidNullException())
        val pollDto = pollConverter.b2dto(poll)

        return VoteProgressStageDto(
            business.type,
            pollDto,
        )
    }

}