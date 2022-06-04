package ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.stage.poll

import org.springframework.stereotype.Component
import ru.smaliav.voting.domain.vote.progress.stage.poll.VotePoll
import ru.smaliav.voting.infrastructure.integration.exception.InvalidNullException
import ru.smaliav.voting.infrastructure.persistence.base.converter.BusinessToEntityConverter
import ru.smaliav.voting.infrastructure.persistence.base.converter.exception.BusinessIdToEntityConversionException
import ru.smaliav.voting.infrastructure.persistence.base.converter.exception.EntityToBusinessIdConversionException

@Component
class VotePollConverter(
    private val pollDao: VotePollDao,
) : BusinessToEntityConverter<
    VotePoll, VotePoll.Id, VotePollEntity
> {
    override fun b2e(business: VotePoll): VotePollEntity {
        return VotePollEntity(
            b2eid(business),
            business.agreed,
            business.rejected,
        )
    }

    override fun e2b(entity: VotePollEntity): VotePoll {
        return VotePoll(
            e2bid(entity) ?: throw InvalidNullException(),
            entity.agreed,
            entity.rejected
        )
    }

    override fun e2bid(entity: VotePollEntity?): VotePoll.Id? {
        if (entity == null) return null
        val id = entity.id ?: throw EntityToBusinessIdConversionException(
            VotePollEntity::class, VotePoll.Id::class
        )
        return VotePoll.Id(id)
    }

    override fun b2eid(business: VotePoll): Int? {
        return business.id?.value
    }

    override fun bid2e(businessId: VotePoll.Id?): VotePollEntity? {
        if (businessId == null) return null
        val id = businessId.value ?: throw BusinessIdToEntityConversionException(
            VotePoll.Id::class, VotePollEntity::class
        )
        return pollDao.getById(id)
    }
}