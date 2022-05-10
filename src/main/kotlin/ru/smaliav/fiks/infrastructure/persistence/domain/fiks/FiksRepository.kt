package ru.smaliav.fiks.infrastructure.persistence.domain.fiks

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import ru.smaliav.fiks.domain.fiks.Fiks

@Repository
class FiksRepository @Autowired constructor(
    private val fiksDao: FiksDao,
    private val fiksConverter: FiksConverter,
) {

    fun getById(id: Int): Fiks? {
        val entity = fiksDao.getById(id) ?: return null
        return fiksConverter.e2b(entity)
    }

}