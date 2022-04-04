package ru.smaliav.fiks.domain.fiks.gate

import ru.smaliav.fiks.domain.user.User

/**
 * Локальный шлюз прямого распределения (ШПРЛ, GDDL)
 */
class LocalDirectDistributionGate(initiator: User): DirectDistributionGate(initiator)
