package ru.smaliav.fiks.infrastructure.integration.fiks

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.smaliav.fiks.domain.fiks.Fiks
import ru.smaliav.fiks.domain.fiks.FiksTarget
import ru.smaliav.fiks.infrastructure.persistence.domain.fiks.FiksRepository
import javax.transaction.Transactional

@Service
class FiksService @Autowired constructor(
    private val fiksRepo: FiksRepository,
) {

    @Transactional
    fun createFiks(fiksDto: FiksDto): Fiks {
        val fiks = Fiks(
            fiksDto.name,
            fiksDto.expires,
            FiksTarget.Id(fiksDto.targetId),
        )
        fiks.description = fiksDto.description

        return fiksRepo.save(fiks)
    }

}