package ru.smaliav.voting.infrastructure.integration.base.converter

import kotlin.reflect.KClass

/**
 * Ошибка при конвертации бизнес-объекта в DTO-объект
 */
class BusinessToDtoConversionException(
    businessClass: KClass<*>, dtoClass: KClass<*>
) : RuntimeException(
    "Ошибка при конверации business-объекта {$businessClass} в dto-объект {$dtoClass}"
)
