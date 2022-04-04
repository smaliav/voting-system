package ru.smaliav.fiks.domain.fiks.progress.stage

enum class FiksStageType(private val id: Int, private val description: String) {

    GROUP  (1, "Локальная группа"),
    EXPERT (2, "Экспертная группа"),
    PUBLIC (3, "Публичный опрос"),

}
