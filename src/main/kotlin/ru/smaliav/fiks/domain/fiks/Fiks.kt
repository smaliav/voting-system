package ru.smaliav.fiks.domain.fiks

import ru.smaliav.fiks.common.`object`.AggregateRoot
import ru.smaliav.fiks.common.`object`.IntegerEntityId
import java.time.Instant

class Fiks(
    val name: String,
    val expires: Long,
    val targetId: FiksTarget.Id,
    val created: Instant = Instant.now(),
): AggregateRoot<Fiks.Id>() {

    var description = ""

    // TODO Прогресс ФИКСа
    // val progressId: FiksProgress.Id
    // TODO ФиксЧат
    // val chatId: FiksChat.Id

    class Id(id: Int): IntegerEntityId(id)
}
