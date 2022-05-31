package ru.smaliav.voting.domain.user

import ru.smaliav.voting.common.`object`.AggregateRoot
import ru.smaliav.voting.common.`object`.IntegerEntityId
import java.math.BigDecimal

class Account: AggregateRoot<Account.Id>() {

    private val balance = BigDecimal.ZERO

    inner class Id(id: Int): IntegerEntityId(id)
}
