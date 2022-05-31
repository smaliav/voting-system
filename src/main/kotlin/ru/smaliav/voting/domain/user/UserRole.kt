package ru.smaliav.voting.domain.user

import ru.smaliav.voting.common.`object`.IEnumWithId

enum class UserRole(override val id: Int, val desc: String): IEnumWithId<Int> {
    FOUNDER (1, "Основатель"),
    ADMIN   (2, "Администратор"),
    BASE    (3, "Базовый"),
    SPECIAL (4, "Эксперт"),
    PRO     (5, "ПРО"),
}
