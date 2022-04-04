package ru.smaliav.fiks.domain.fiks.chat

import ru.smaliav.fiks.common.`object`.AggregateRoot
import ru.smaliav.fiks.common.`object`.IntegerEntityId

class FiksChat(val name: String): AggregateRoot<FiksChat.Id>() {

    inner class Id: IntegerEntityId()
}
