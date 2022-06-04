package ru.smaliav.voting.infrastructure.persistence.domain.vote.progress

import org.springframework.stereotype.Component
import ru.smaliav.voting.domain.vote.progress.VoteProgress
import ru.smaliav.voting.infrastructure.integration.exception.InvalidNullException
import ru.smaliav.voting.infrastructure.persistence.base.converter.BusinessToEntityConverter
import ru.smaliav.voting.infrastructure.persistence.base.converter.exception.EntityToBusinessIdConversionException
import ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.stage.VoteProgressStageConverter

@Component
class VoteProgressConverter(
    private val progressDao: VoteProgressDao,
    private val stageConverter: VoteProgressStageConverter,
) : BusinessToEntityConverter<VoteProgress, VoteProgress.Id, VoteProgressEntity> {

    override fun b2e(business: VoteProgress): VoteProgressEntity {
        return VoteProgressEntity(
            business.id?.value,
            stageConverter.bid2e(business.groupStageId) ?: throw InvalidNullException(),
            stageConverter.bid2e(business.expertStageId),
            stageConverter.bid2e(business.publicStageId),
            business.state,
        )
    }

    override fun e2b(entity: VoteProgressEntity): VoteProgress {
        return VoteProgress(
            e2bid(entity) ?: throw InvalidNullException(),
            stageConverter.e2bid(entity.groupStage) ?: throw InvalidNullException(),
            stageConverter.e2bid(entity.expertStage),
            stageConverter.e2bid(entity.publicStage),
            entity.state
        )
    }

    override fun e2bid(entity: VoteProgressEntity?): VoteProgress.Id? {
        if (entity == null) return null
        val id = entity.id ?: throw EntityToBusinessIdConversionException(
            VoteProgressEntity::class, VoteProgress.Id::class
        )
        return VoteProgress.Id(id)
    }

    override fun b2eid(business: VoteProgress): Int? {
        return business.id?.value
    }

    override fun bid2e(businessId: VoteProgress.Id?): VoteProgressEntity? {
        if (businessId == null) return null
        val id = businessId.value ?: throw InvalidNullException()
        return progressDao.getById(id)
    }

    fun eid2bid(eid: Int?): VoteProgress.Id {
        if (eid == null) throw InvalidNullException()
        return VoteProgress.Id(eid)
    }

}