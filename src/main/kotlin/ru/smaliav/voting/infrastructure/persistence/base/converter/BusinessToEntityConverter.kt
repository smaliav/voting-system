package ru.smaliav.voting.infrastructure.persistence.base.converter

import ru.smaliav.voting.common.`object`.AggregateRoot
import ru.smaliav.voting.common.`object`.IntegerEntityId
import ru.smaliav.voting.infrastructure.persistence.base.EntityWithIntId

// TODO Проверить, что все Business-to-Entity конвертеры реализуют этот интерфейс
interface BusinessToEntityConverter<
    B : AggregateRoot<BID>, BID : IntegerEntityId, E : EntityWithIntId
> {
    // Конвертация сущностей
    fun b2e(business: B): E
    fun e2b(entity: E): B
    // Конвертация в Id
    fun e2bid(entity: E): BID
    fun b2eid(business: B): Int?
    // Конвератция из Id
    fun bid2e(businessId: BID): E
}