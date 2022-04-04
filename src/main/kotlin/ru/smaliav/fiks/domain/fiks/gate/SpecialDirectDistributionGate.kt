package ru.smaliav.fiks.domain.fiks.gate

import ru.smaliav.fiks.domain.user.User

/**
 * Специальный шлюз прямого распределения (ШПРС, GDDS)
 */
class SpecialDirectDistributionGate(initiator: User): DirectDistributionGate(initiator)
