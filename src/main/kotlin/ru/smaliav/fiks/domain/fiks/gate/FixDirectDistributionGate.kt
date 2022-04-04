package ru.smaliav.fiks.domain.fiks.gate

import ru.smaliav.fiks.domain.user.User

/**
 * Фиксирующий шлюз прямого распределения (ШПРФ, GDDF)
 */
class FixDirectDistributionGate(initiator: User): DirectDistributionGate(initiator)
