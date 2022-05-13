package ru.smaliav.fiks.domain.fiks

import ru.smaliav.fiks.common.`object`.AggregateRoot
import ru.smaliav.fiks.common.`object`.IntegerEntityId

class FiksTarget(
    val name: String,
    val code: String,
): AggregateRoot<FiksTarget.Id>() {

    class Id(id: Int): IntegerEntityId(id)
}
