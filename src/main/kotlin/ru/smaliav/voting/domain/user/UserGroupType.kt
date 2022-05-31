package ru.smaliav.voting.domain.user

import ru.smaliav.voting.common.`object`.IEnumWithId

enum class UserGroupType(override val id: Int, name: String): IEnumWithId<Int> {
    COMMON  (1, "Общая"),
    PRIVATE (2, "Закрытая"),
}
