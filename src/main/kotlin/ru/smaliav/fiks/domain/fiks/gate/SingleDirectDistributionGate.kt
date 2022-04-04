package ru.smaliav.fiks.domain.fiks.gate

import ru.smaliav.fiks.domain.user.User

/**
 * Одиночный шлюз прямого распределения (ШПРО, GDDO)
 */
class SingleDirectDistributionGate(initiator: User): DirectDistributionGate(initiator)
