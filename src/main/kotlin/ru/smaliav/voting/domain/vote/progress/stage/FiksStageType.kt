package ru.smaliav.voting.domain.vote.progress.stage

import ru.smaliav.voting.common.`object`.IEnumWithId

enum class FiksStageType(override val id: Int, private val desc: String): IEnumWithId<Int> {
    GROUP  (1, "Локальная группа"),
    EXPERT (2, "Экспертная группа"),
    PUBLIC (3, "Публичный опрос"),
}
