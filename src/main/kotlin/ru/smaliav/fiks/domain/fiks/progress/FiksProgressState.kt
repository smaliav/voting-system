package ru.smaliav.fiks.domain.fiks.progress

enum class FiksProgressState(private val id: Int, private val description: String) {
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
