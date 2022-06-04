package ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.stage

import org.springframework.stereotype.Repository
import ru.smaliav.voting.domain.vote.progress.stage.VoteProgressStage

@Repository
class VoteProgressStageRepository(
    private val stageDao: VoteProgressStageDao,
    private val stageConverter: VoteProgressStageConverter,
) {

    fun save(stage: VoteProgressStage): VoteProgressStage {
        var entity = stageConverter.b2e(stage)
        entity = stageDao.saveOrUpdate(entity)
        return stageConverter.e2b(entity)
    }

}