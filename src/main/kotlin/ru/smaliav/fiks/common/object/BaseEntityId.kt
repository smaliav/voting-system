package ru.smaliav.fiks.common.`object`

import java.io.Serializable

abstract class BaseEntityId<ID: Serializable>(val value: ID? = null)
