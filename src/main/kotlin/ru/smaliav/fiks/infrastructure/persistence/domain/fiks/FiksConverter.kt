package ru.smaliav.fiks.infrastructure.persistence.domain.fiks

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.smaliav.fiks.domain.fiks.Fiks
import ru.smaliav.fiks.domain.fiks.FiksTarget
import ru.smaliav.fiks.infrastructure.persistence.domain.fiks.trg.FiksTargetConverter

@Service
class FiksConverter @Autowired constructor(
    private val targetConverter: FiksTargetConverter,
) {

    fun e2b(entity: FiksEntity): Fiks {
        val res = Fiks(
            entity.name,
            entity.expires,
            FiksTarget.Id(entity.target.id),
            entity.created,
        )
        res.id = Fiks.Id(entity.id!!)
        res.description = entity.description

        return res
    }

    fun b2e(business: Fiks): FiksEntity {
        return FiksEntity(
            business.id?.value,
            business.name,
            business.expires,
            business.created,
            business.description,
            targetConverter.bid2e(business.targetId),
        )
    }

}