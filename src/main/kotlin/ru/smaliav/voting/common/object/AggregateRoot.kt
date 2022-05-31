package ru.smaliav.voting.common.`object`

/**
 * Неотъемлемая часть при проектировании системы по DDD (Domain-Driver Design)
 * Сюда можно добавить управление событиями доменных объектов
 */
abstract class AggregateRoot<ID: BaseEntityId<*>>: BaseEntity<ID>(null)
