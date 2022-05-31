package ru.smaliav.voting.domain.vote

import ru.smaliav.voting.common.`object`.AggregateRoot
import ru.smaliav.voting.common.`object`.IntegerEntityId
import ru.smaliav.voting.domain.vote.progress.VoteProgress
import java.time.Instant

class Vote(
    val name: String,
    val expires: Long,
    val targetId: VoteTarget.Id,
    val progressId: VoteProgress.Id,
    val created: Instant = Instant.now(),
): AggregateRoot<Vote.Id>() {

    var description = ""

    // TODO Чат голосования
    // val chatId: VoteChat.Id

    class Id(id: Int): IntegerEntityId(id)
}
