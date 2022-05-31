package ru.smaliav.voting.infrastructure.persistence.domain.vote

import ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.VoteProgressEntity
import ru.smaliav.voting.infrastructure.persistence.domain.vote.trg.FiksTargetEntity
import java.time.Instant
import javax.persistence.*

// TODO Переименовать табличку
@Table(name = "fiks")
@Entity
class VoteEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int?,

    @Column(name = "name")
    val name: String,

    @Column(name = "expires")
    val expires: Long,

    @Column(name = "created")
    val created: Instant,

    @Column(name = "description")
    val description: String,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [ CascadeType.ALL ])
    @JoinColumn(name = "target")
    val target: FiksTargetEntity,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [ CascadeType.ALL ])
    @JoinColumn(name = "progress")
    val progress: VoteProgressEntity

)
