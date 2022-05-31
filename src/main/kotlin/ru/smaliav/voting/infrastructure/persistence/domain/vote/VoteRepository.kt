package ru.smaliav.voting.infrastructure.persistence.domain.vote

import org.springframework.stereotype.Repository
import ru.smaliav.voting.domain.vote.Vote
import ru.smaliav.voting.infrastructure.integration.exception.EntityNotFoundException

@Repository
class VoteRepository(
    private val voteDao: VoteDao,
    private val voteConverter: VoteConverter,
) {

    fun getById(id: Int): Vote {
        val entity = voteDao.getById(id) ?: throw EntityNotFoundException(VoteEntity::class, id)
        return voteConverter.e2b(entity)
    }

    fun save(vote: Vote): Vote {
        var entity = voteConverter.b2e(vote)
        entity = voteDao.saveOrUpdate(entity)
        return voteConverter.e2b(entity)
    }

}