package ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.stage.poll

import ru.smaliav.voting.infrastructure.persistence.base.EntityWithIntId
import javax.persistence.*

@Table(name = "vote_poll")
@Entity
class VotePollEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    override val id: Int?,

    @Column(name = "agreed")
    val agreed: Int,

    @Column(name = "rejected")
    val rejected: Int,

) : EntityWithIntId