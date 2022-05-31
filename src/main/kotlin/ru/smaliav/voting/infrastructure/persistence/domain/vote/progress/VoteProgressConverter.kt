package ru.smaliav.voting.infrastructure.persistence.domain.vote.progress

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ru.smaliav.voting.domain.vote.progress.VoteProgress
import ru.smaliav.voting.infrastructure.integration.exception.InvalidNullException

@Component
class VoteProgressConverter @Autowired constructor(
    private val progressDao: VoteProgressDao,
) {

    fun b2e(progress: VoteProgress): VoteProgressEntity {
        return VoteProgressEntity(
            bid2eid(progress.id),
            progress.state,
        )
    }

    fun bid2eid(bid: VoteProgress.Id?): Int? {
        return bid?.value
    }

    fun eid2bid(eid: Int?): VoteProgress.Id {
        if (eid == null) throw InvalidNullException()
        return VoteProgress.Id(eid)
    }

    fun bid2e(bid: VoteProgress.Id): VoteProgressEntity {
        val id = bid.value ?: throw InvalidNullException()
        return progressDao.getById(id)
    }

}