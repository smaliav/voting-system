package ru.smaliav.voting.infrastructure.integration.exception

import kotlin.reflect.KClass

class EntityNotFoundException(
    val entityClass: KClass<*>,
    val id: Int,
) : RuntimeException("Entity {$entityClass} with ID = {$id} Not Found")
