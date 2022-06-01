package ru.smaliav.voting.infrastructure.persistence.base.converter.exception

import kotlin.reflect.KClass

class BusinessIdToEntityConversionException(
    businessIdClass: KClass<*>, entityClass: KClass<*>
) : Exception(
    "Невозможно конвертировать бизнес-Id {$businessIdClass} с null в сущность {$entityClass}"
)