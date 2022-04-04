package ru.smaliav.fiks.common.`object`

open class BaseEntity<ID: BaseEntityId<*>>(private var id: ID? = null)
