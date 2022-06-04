package ru.smaliav.voting.infrastructure.persistence.domain.vote.progress

import ru.smaliav.voting.domain.vote.progress.VoteProgressState
import ru.smaliav.voting.infrastructure.persistence.base.EntityWithIntId
import ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.stage.VoteProgressStageEntity
import javax.persistence.*

@Table(name = "vote_progress")
@Entity
class VoteProgressEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    override val id: Int?,

    @OneToOne
    @JoinColumn(name = "group_stage")
    val groupStage: VoteProgressStageEntity,

    @OneToOne
    @JoinColumn(name = "expert_stage")
    val expertStage: VoteProgressStageEntity?,

    @OneToOne
    @JoinColumn(name = "public_stage")
    val publicStage: VoteProgressStageEntity?,

    @Column(name = "state")
    val state: VoteProgressState,

) : EntityWithIntId
