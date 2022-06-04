package ru.smaliav.voting.domain.vote.progress.stage

import ru.smaliav.voting.common.`object`.AggregateRoot
import ru.smaliav.voting.common.`object`.IntegerEntityId

class VoteProgressStage(
    val type: VoteProgressStageType,
    // TODO Опрос к этапу
    // val pollId: PollEntity.Id,
): AggregateRoot<VoteProgressStage.Id>() {

//    val poll = VotePoll()

    class Id(id: Int): IntegerEntityId(id)
}
