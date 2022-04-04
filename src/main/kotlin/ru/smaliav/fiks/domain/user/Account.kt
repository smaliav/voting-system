package ru.smaliav.fiks.domain.user

import ru.smaliav.fiks.common.`object`.AggregateRoot
import ru.smaliav.fiks.common.`object`.IntegerEntityId
import java.math.BigDecimal

class Account: AggregateRoot<Account.Id>() {

    private val balance = BigDecimal.ZERO

    inner class Id: IntegerEntityId()
}
