package ru.smaliav.fiks.domain.fiks

import ru.smaliav.fiks.common.`object`.AggregateRoot
import ru.smaliav.fiks.common.`object`.IntegerEntityId
import ru.smaliav.fiks.domain.fiks.chat.FiksChat
import ru.smaliav.fiks.domain.fiks.progress.FiksProgress
import java.time.Instant

class Fiks(
    val name: String,
    val expires: Long,
    val targetId: FiksTarget.Id,
): AggregateRoot<Fiks.Id>() {

    val created = Instant.now()
    val progress = FiksProgress()
    var description = ""
    val chat = FiksChat("New chat")

    inner class Id: IntegerEntityId()
}
