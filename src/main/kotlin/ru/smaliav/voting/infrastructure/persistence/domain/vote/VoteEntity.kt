package ru.smaliav.voting.infrastructure.persistence.domain.vote

import ru.smaliav.voting.infrastructure.persistence.domain.vote.chat.VoteChatEntity
import ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.VoteProgressEntity
import ru.smaliav.voting.infrastructure.persistence.domain.vote.trg.FiksTargetEntity
import java.time.Instant
import javax.persistence.*

@Table(name = "vote")
@Entity
class VoteEntity(

    // TODO Вынести Id в родительский класс
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

    // TODO Проверить верность отношения
    @ManyToOne(fetch = FetchType.LAZY, cascade = [ CascadeType.ALL ])
    @JoinColumn(name = "target")
    val target: FiksTargetEntity,

    // TODO Проверить верность отношения
    @ManyToOne(fetch = FetchType.LAZY, cascade = [ CascadeType.ALL ])
    @JoinColumn(name = "progress")
    val progress: VoteProgressEntity,

    @OneToOne
    @JoinColumn(name = "chat")
    val chat: VoteChatEntity,

)
