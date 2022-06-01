package ru.smaliav.voting.infrastructure.persistence.domain.user

import ru.smaliav.voting.infrastructure.persistence.base.EntityWithIntId
import javax.persistence.*

@Table(name = "vote_user")
@Entity
class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    override val id: Int?,

    @Column(name = "nickname")
    val nickname: String,

    // TODO Роли
    // TODO Счет

) : EntityWithIntId