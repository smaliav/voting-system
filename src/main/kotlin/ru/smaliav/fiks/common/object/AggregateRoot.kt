package ru.smaliav.fiks.common.`object`

abstract class AggregateRoot<ID: BaseEntityId<*>>: BaseEntity<ID>(null) {
    // TODO Events?
}
