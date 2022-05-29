package ru.smaliav.fiks.infrastructure.persistence.domain.fiks.progress

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import ru.smaliav.fiks.domain.fiks.progress.VoteProgress

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