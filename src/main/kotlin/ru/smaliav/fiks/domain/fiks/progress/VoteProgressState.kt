package ru.smaliav.fiks.domain.fiks.progress

import ru.smaliav.fiks.common.`object`.IEnumWithId

enum class VoteProgressState(override val id: Int, private val desc: String): IEnumWithId<Int> {
    CREATED              (1, "Создан"),
    MODERATING           (2, "На модерации"),
    MODERATING_REJECTED  (3, "Модерация не пройдена"),
    GROUP_POLL           (4, "Локальный опрос"),
    GROUP_POLL_REJECTED  (5, "Локальный опрос не пройден"),
    EXPERT_POLL          (6, "Экспертный опрос"),
    EXPERT_POLL_REJECTED (7, "Экспертный опрос не пройден"),
    PUBLIC_POLL          (8, "Публичный опрос"),
    PUBLIC_POLL_REJECTED (9, "Публичный опрос не пройден"),
    ACCEPTED             (10, "Принят"),
    IN_PROGRESS          (11, "На исполнении"),
    COMPLETED            (12, "Исполнен"),
    ERROR                (13, "Ошибка"),
}
