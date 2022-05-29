package ru.smaliav.fiks.infrastructure.persistence.domain.fiks.progress

import ru.smaliav.fiks.domain.fiks.progress.VoteProgressState
import ru.smaliav.fiks.infrastructure.persistence.base.EntityWithId
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
