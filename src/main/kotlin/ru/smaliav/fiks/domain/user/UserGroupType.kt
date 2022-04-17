package ru.smaliav.fiks.domain.user

import ru.smaliav.fiks.common.`object`.IEnumWithId

enum class UserGroupType(override val id: Int, name: String): IEnumWithId<Int> {
    COMMON  (1, "Общая"),
    PRIVATE (2, "Закрытая"),
}
