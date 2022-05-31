package ru.smaliav.voting.infrastructure.persistence.domain.vote.trg

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ru.smaliav.voting.domain.vote.VoteTarget
import ru.smaliav.voting.infrastructure.integration.exception.EntityNotFoundException
import ru.smaliav.voting.infrastructure.integration.exception.InvalidNullException

@Component
class VoteTargetConverter @Autowired constructor(
    private val fiksTargetDao: FiksTargetDao,
) {

    fun bid2e(bId: VoteTarget.Id): FiksTargetEntity {
        val id = bId.value ?: throw InvalidNullException()
        return fiksTargetDao.getById(id) ?: throw EntityNotFoundException(FiksTargetEntity::class, id)
    }

}