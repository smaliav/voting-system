package ru.smaliav.voting.common.`object`

abstract class AggregateRoot<ID: BaseEntityId<*>>: BaseEntity<ID>(null) {
    // TODO Events?
}
