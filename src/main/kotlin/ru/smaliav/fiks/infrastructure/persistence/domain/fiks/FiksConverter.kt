package ru.smaliav.fiks.infrastructure.persistence.domain.fiks

import org.springframework.stereotype.Service
import ru.smaliav.fiks.domain.fiks.Fiks
import kotlin.reflect.full.primaryConstructor

@Service
class FiksConverter {

    fun e2b(entity: FiksEntity): Fiks {
        val res = Fiks(
            entity.name,
            entity.expires,
            entity.created
        )
        val constructor = Fiks.Id::class.primaryConstructor
        res.id = constructor?.call(res, entity.id)

        res.description = entity.description
        return res
    }

}