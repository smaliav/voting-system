package ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.stage

import org.springframework.stereotype.Repository
import ru.smaliav.voting.domain.vote.progress.stage.VoteProgressStage
import ru.smaliav.voting.infrastructure.integration.exception.InvalidNullException

@Repository
class VoteProgressStageRepository(
    private val stageDao: VoteProgressStageDao,
    private val stageConverter: VoteProgressStageConverter,
) {

    fun getById(businessId: VoteProgressStage.Id): VoteProgressStage {
        val id = businessId.value ?: throw InvalidNullException()
        val entity = stageDao.getById(id)
        return stageConverter.e2b(entity)
    }

    fun save(stage: VoteProgressStage): VoteProgressStage {
        var entity = stageConverter.b2e(stage)
        entity = stageDao.saveOrUpdate(entity)
        return stageConverter.e2b(entity)
    }

}