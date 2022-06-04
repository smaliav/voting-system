package ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.stage

import ru.smaliav.voting.domain.vote.progress.stage.VoteProgressStageType
import ru.smaliav.voting.infrastructure.persistence.base.EntityWithIntId
import javax.persistence.*

@Table(name = "vote_progress_stage")
@Entity
class VoteProgressStageEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    override val id: Int?,

    @Column(name = "type")
    val type: VoteProgressStageType,

) : EntityWithIntId