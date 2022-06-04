package ru.smaliav.voting.infrastructure.persistence.domain.vote.progress

import org.springframework.stereotype.Repository
import ru.smaliav.voting.domain.vote.progress.VoteProgress
import ru.smaliav.voting.infrastructure.integration.exception.InvalidNullException

@Repository
class VoteProgressRepository(
    private val progressDao: VoteProgressDao,
    private val progressConverter: VoteProgressConverter,
) {

    fun getById(businessId: VoteProgress.Id): VoteProgress {
        val id = businessId.value ?: throw InvalidNullException()
        val entity = progressDao.getById(id)
        return progressConverter.e2b(entity)
    }

    fun save(progress: VoteProgress): VoteProgress.Id {
        var entity = progressConverter.b2e(progress)
        entity = progressDao.saveOrUpdate(entity)
        return progressConverter.eid2bid(entity.id)
    }

}