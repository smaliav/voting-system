package ru.smaliav.voting.infrastructure.persistence.domain.vote.trg

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import ru.smaliav.voting.infrastructure.integration.exception.EntityNotFoundException

@Repository
class FiksTargetRepository @Autowired constructor(
    private val fiksTargetDao: FiksTargetDao,
) {

    fun getById(id: Int): FiksTargetEntity {
        return fiksTargetDao.getById(id) ?: throw EntityNotFoundException(FiksTargetEntity::class, id)
    }

}