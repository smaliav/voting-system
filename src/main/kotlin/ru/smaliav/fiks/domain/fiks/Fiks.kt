package ru.smaliav.fiks.domain.fiks

import ru.smaliav.fiks.common.`object`.AggregateRoot
import ru.smaliav.fiks.common.`object`.IntegerEntityId
import ru.smaliav.fiks.domain.fiks.progress.FiksProgress
import java.time.Instant

class Fiks(
    val name: String,
    val expires: Long,
    val created: Instant = Instant.now()
    // TODO Цель ФИКСа
    // val targetId: FiksTarget.Id, // Не совсем пока понятно, что это, и как должно быть реализовано
): AggregateRoot<Fiks.Id>() {

    var description = ""

    // TODO Прогресс ФИКСа
    // val progressId: FiksProgress.Id
    // TODO ФиксЧат
    // val chatId: FiksChat.Id

    inner class Id(id: Int): IntegerEntityId(id)
}
