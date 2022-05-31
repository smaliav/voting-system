package ru.smaliav.voting.infrastructure.persistence.domain.vote.progress

import ru.smaliav.voting.domain.vote.progress.VoteProgressState
import ru.smaliav.voting.infrastructure.persistence.base.EntityWithId
import javax.persistence.*

// TODO Переименовать табличку
@Table(name = "fiks_progress")
@Entity
class VoteProgressEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    override val id: Int?,

    @Column(name = "state")
    val state: VoteProgressState,

    ) : EntityWithId
