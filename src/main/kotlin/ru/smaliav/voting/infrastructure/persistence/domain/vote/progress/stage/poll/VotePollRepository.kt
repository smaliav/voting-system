package ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.stage.poll

import org.springframework.stereotype.Repository
import ru.smaliav.voting.domain.vote.progress.stage.poll.VotePoll

@Repository
class VotePollRepository(
    private val pollDao: VotePollDao,
    private val pollConverter: VotePollConverter,
) {

    fun save(poll: VotePoll): VotePoll {
        var entity = pollConverter.b2e(poll)
        entity = pollDao.saveOrUpdate(entity)
        return pollConverter.e2b(entity)
    }

}