package ru.smaliav.voting.infrastructure.persistence.domain.vote.chat

import ru.smaliav.voting.infrastructure.persistence.base.EntityWithId
import javax.persistence.*

@Table(name = "vote_chat")
@Entity
class VoteChatEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    override val id: Int?,

    @Column(name = "name")
    val name: String,

) : EntityWithId