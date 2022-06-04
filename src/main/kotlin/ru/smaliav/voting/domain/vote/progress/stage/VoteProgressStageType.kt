package ru.smaliav.voting.domain.vote.progress.stage

import ru.smaliav.voting.common.`object`.IEnumWithId

enum class VoteProgressStageType(override val id: Int, private val desc: String): IEnumWithId<Int> {
    GROUP  (0, "Локальная группа"),
    EXPERT (1, "Экспертная группа"),
    PUBLIC (2, "Публичный опрос"),
}
