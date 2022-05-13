package ru.smaliav.fiks.infrastructure.integration.fiks

data class FiksDto(
    var name: String,
    var expires: Long,
    var targetId: Int,
    var description: String,
)
