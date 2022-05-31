package ru.smaliav.voting.infrastructure.persistence.domain.user

import ru.smaliav.voting.domain.user.UserGroupType
import javax.persistence.*

@Table(name = "user_group")
@Entity
class UserGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int? = null

    @Column(name = "type")
    lateinit var type: UserGroupType

    @Column(name = "name")
    lateinit var name: String

}
