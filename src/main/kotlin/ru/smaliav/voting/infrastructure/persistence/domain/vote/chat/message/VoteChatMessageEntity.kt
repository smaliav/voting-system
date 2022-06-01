package ru.smaliav.voting.infrastructure.persistence.domain.vote.chat.message

import ru.smaliav.voting.infrastructure.persistence.base.EntityWithIntId
import ru.smaliav.voting.infrastructure.persistence.domain.user.UserEntity
import ru.smaliav.voting.infrastructure.persistence.domain.vote.chat.VoteChatEntity
import java.time.Instant
import javax.persistence.*

@Table(name = "vote_chat_message")
@Entity
class VoteChatMessageEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    override val id: Int?,

    @ManyToOne
    @JoinColumn(name = "chat")
    val chat: VoteChatEntity,

    @ManyToOne
    @JoinColumn(name = "vote_user")
    val user: UserEntity,

    @Column(name = "content")
    val content: String,

    @Column(name = "sent")
    val sent: Instant,

) : EntityWithIntId