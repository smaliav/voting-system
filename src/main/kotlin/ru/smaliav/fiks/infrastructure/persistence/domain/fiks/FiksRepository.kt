package ru.smaliav.fiks.infrastructure.persistence.domain.fiks

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import ru.smaliav.fiks.domain.fiks.Fiks
import ru.smaliav.fiks.infrastructure.integration.exception.EntityNotFoundException

@Repository
class FiksRepository @Autowired constructor(
    private val fiksDao: FiksDao,
    private val fiksConverter: FiksConverter,
) {

    fun getById(id: Int): Fiks {
        val entity = fiksDao.getById(id) ?: throw EntityNotFoundException(FiksEntity::class, id)
        return fiksConverter.e2b(entity)
    }

    fun save(fiks: Fiks): Fiks {
        var entity = fiksConverter.b2e(fiks)
        entity = fiksDao.saveOrUpdate(entity)
        return fiksConverter.e2b(entity)
    }

}