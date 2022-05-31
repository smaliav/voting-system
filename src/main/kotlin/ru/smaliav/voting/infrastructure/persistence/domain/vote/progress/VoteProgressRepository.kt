package ru.smaliav.voting.infrastructure.persistence.domain.vote.progress

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import ru.smaliav.voting.domain.vote.progress.VoteProgress

@Repository
class VoteProgressRepository @Autowired constructor(
    private val progressDao: VoteProgressDao,
    private val progressConverter: VoteProgressConverter,
) {

    fun save(progress: VoteProgress): VoteProgress.Id {
        var entity = progressConverter.b2e(progress)
        entity = progressDao.saveOrUpdate(entity)
        return progressConverter.eid2bid(entity.id)
    }

}