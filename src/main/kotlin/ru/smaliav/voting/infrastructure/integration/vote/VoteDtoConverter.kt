package ru.smaliav.voting.infrastructure.integration.vote

import org.springframework.stereotype.Component
import ru.smaliav.voting.domain.vote.Vote
import ru.smaliav.voting.infrastructure.integration.exception.InvalidNullException
import ru.smaliav.voting.infrastructure.integration.vote.progress.VoteProgressDtoConverter
import ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.VoteProgressRepository

@Component
class VoteDtoConverter(
    private val progressRepo: VoteProgressRepository,
    private val progressConverter: VoteProgressDtoConverter,
) {

    fun b2dto(business: Vote): VoteDto {

        val progress = progressRepo.getById(business.progressId)
        val progressDto = progressConverter.b2dto(progress)

        return VoteDto(
            business.id?.value ?: throw InvalidNullException(),
            business.name,
            business.description,
            business.expires,
            progressDto,
        )
    }

}