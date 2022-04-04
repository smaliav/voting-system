package ru.smaliav.fiks.common.`object`

import java.io.Serializable

abstract class BaseEntityId<ID: Serializable>(private val id: ID? = null)
