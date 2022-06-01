package ru.smaliav.voting.infrastructure.persistence.base.converter.exception

import kotlin.reflect.KClass

class EntityToBusinessIdConversionException(
    entityClass: KClass<*>, businessIdClass: KClass<*>
) : Exception(
    "Невозможно конвертировать сущность {$entityClass} с null Id в бизнес-Id {$businessIdClass}"
)