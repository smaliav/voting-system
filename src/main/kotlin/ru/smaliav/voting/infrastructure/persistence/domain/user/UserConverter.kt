package ru.smaliav.voting.infrastructure.persistence.domain.user

import org.springframework.stereotype.Component
import ru.smaliav.voting.domain.user.User
import ru.smaliav.voting.infrastructure.integration.exception.InvalidNullException
import ru.smaliav.voting.infrastructure.persistence.base.converter.BusinessToEntityConverter
import ru.smaliav.voting.infrastructure.persistence.base.converter.exception.BusinessIdToEntityConversionException
import ru.smaliav.voting.infrastructure.persistence.base.converter.exception.EntityToBusinessIdConversionException

@Component
class UserConverter(
    private val userDao: UserDao,
) : BusinessToEntityConverter<User, User.Id, UserEntity> {

    override fun b2e(business: User): UserEntity {
        return UserEntity(
            business.id?.value,
            business.nickname,
        )
    }

    override fun e2b(entity: UserEntity): User {
        val business = User(
            entity.nickname,
        )
        val id = entity.id ?: throw InvalidNullException()
        business.id = User.Id(id)

        return business
    }

    override fun e2bid(entity: UserEntity): User.Id {
        val id = entity.id ?: throw EntityToBusinessIdConversionException(
            UserEntity::class, User.Id::class
        )
        return User.Id(id)
    }

    override fun b2eid(business: User): Int? = business.id?.value

    override fun bid2e(businessId: User.Id): UserEntity {
        val id = businessId.value ?: throw BusinessIdToEntityConversionException(User.Id::class, UserEntity::class)
        return userDao.getById(id)
    }

}