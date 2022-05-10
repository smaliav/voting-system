package ru.smaliav.fiks.domain.fiks.gate

import ru.smaliav.fiks.common.`object`.IntegerEntityId
import ru.smaliav.fiks.domain.user.User

/**
 * Шлюз прямого распределения (ШПР, GDD)
 */
abstract class DirectDistributionGate(val initiator: User) {

    inner class Id(id: Int): IntegerEntityId(id)
}
