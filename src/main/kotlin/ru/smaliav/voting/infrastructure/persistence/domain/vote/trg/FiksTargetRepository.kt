package ru.smaliav.voting.infrastructure.persistence.domain.vote.trg

import org.springframework.stereotype.Repository
import ru.smaliav.voting.infrastructure.integration.exception.EntityNotFoundException

@Repository
class FiksTargetRepository(
    private val fiksTargetDao: FiksTargetDao,
) {

    fun getById(id: Int): FiksTargetEntity {
        return fiksTargetDao.getById(id) ?: throw EntityNotFoundException(FiksTargetEntity::class, id)
    }

}