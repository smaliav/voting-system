package ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.stage

import org.springframework.stereotype.Component
import ru.smaliav.voting.domain.vote.progress.stage.VoteProgressStage
import ru.smaliav.voting.infrastructure.integration.exception.InvalidNullException
import ru.smaliav.voting.infrastructure.persistence.base.converter.BusinessToEntityConverter
import ru.smaliav.voting.infrastructure.persistence.base.converter.exception.BusinessIdToEntityConversionException
import ru.smaliav.voting.infrastructure.persistence.base.converter.exception.EntityToBusinessIdConversionException
import ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.stage.poll.VotePollConverter

@Component
class VoteProgressStageConverter(
    private val stageDao: VoteProgressStageDao,
    private val pollConverter: VotePollConverter,
) : BusinessToEntityConverter<VoteProgressStage, VoteProgressStage.Id, VoteProgressStageEntity> {

    override fun b2e(business: VoteProgressStage): VoteProgressStageEntity {
        return VoteProgressStageEntity(
            business.id?.value,
            business.type,
            pollConverter.bid2e(business.pollId) ?: throw InvalidNullException()
        )
    }

    override fun e2b(entity: VoteProgressStageEntity): VoteProgressStage {
        val business = VoteProgressStage(
            entity.type,
            pollConverter.e2bid(entity.poll) ?: throw InvalidNullException(),
        )
        business.id = e2bid(entity)
        return business
    }

    override fun e2bid(entity: VoteProgressStageEntity?): VoteProgressStage.Id? {
        if (entity == null) return null
        val id = entity.id ?: throw EntityToBusinessIdConversionException(
            VoteProgressStageEntity::class, VoteProgressStage.Id::class
        )
        return VoteProgressStage.Id(id)
    }

    override fun b2eid(business: VoteProgressStage): Int? {
        return business.id?.value
    }

    override fun bid2e(businessId: VoteProgressStage.Id?): VoteProgressStageEntity? {
        if (businessId == null) return null
        val id = businessId.value ?: throw BusinessIdToEntityConversionException(
            VoteProgressStage.Id::class, VoteProgressStageEntity::class
        )
        return stageDao.getById(id)
    }
}