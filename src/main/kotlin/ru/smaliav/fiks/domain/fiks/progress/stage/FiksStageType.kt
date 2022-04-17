package ru.smaliav.fiks.domain.fiks.progress.stage

import ru.smaliav.fiks.common.`object`.IEnumWithId

enum class FiksStageType(override val id: Int, private val desc: String): IEnumWithId<Int> {
    GROUP  (1, "Локальная группа"),
    EXPERT (2, "Экспертная группа"),
    PUBLIC (3, "Публичный опрос"),
}
