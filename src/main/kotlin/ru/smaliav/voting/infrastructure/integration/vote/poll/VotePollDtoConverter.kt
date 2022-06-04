package ru.smaliav.voting.infrastructure.integration.vote.poll

import org.springframework.stereotype.Component
import ru.smaliav.voting.domain.vote.progress.stage.poll.VotePoll
import ru.smaliav.voting.infrastructure.integration.base.converter.BusinessToDtoConversionException
import ru.smaliav.voting.infrastructure.integration.base.converter.DtoToBusinessConverter

@Component
class VotePollDtoConverter : DtoToBusinessConverter<VotePollDto, VotePoll> {

    override fun dto2b(dto: VotePollDto): VotePoll {
        return VotePoll(
            VotePoll.Id(dto.id),
            dto.agreed,
            dto.rejected,
        )
    }

    override fun b2dto(business: VotePoll): VotePollDto {
        return VotePollDto(
            business.id?.value ?: throw BusinessToDtoConversionException(
                VotePoll::class, VotePollDto::class
            ),
            business.agreed,
            business.rejected,
        )
    }

}
