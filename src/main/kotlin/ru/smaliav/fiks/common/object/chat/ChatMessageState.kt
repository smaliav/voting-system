package ru.smaliav.fiks.common.`object`.chat

import ru.smaliav.fiks.common.`object`.IEnumWithId

enum class ChatMessageState(override val id: Int, val desc: String): IEnumWithId<Int> {
    SENT    (1, "Отправлено"),
    BLOCKED (2, "Заблокировано"),
}
