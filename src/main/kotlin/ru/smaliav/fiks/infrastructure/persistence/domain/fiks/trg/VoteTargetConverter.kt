package ru.smaliav.fiks.infrastructure.persistence.domain.fiks.trg

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ru.smaliav.fiks.domain.fiks.VoteTarget
import ru.smaliav.fiks.infrastructure.integration.exception.EntityNotFoundException
import ru.smaliav.fiks.infrastructure.integration.exception.InvalidNullException

@Component
class VoteTargetConverter @Autowired constructor(
    private val fiksTargetDao: FiksTargetDao,
) {

    fun bid2e(bId: VoteTarget.Id): FiksTargetEntity {
        val id = bId.value ?: throw InvalidNullException()
        return fiksTargetDao.getById(id) ?: throw EntityNotFoundException(FiksTargetEntity::class, id)
    }

}