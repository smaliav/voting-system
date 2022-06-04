package ru.smaliav.voting.domain.vote.progress.stage

import ru.smaliav.voting.common.`object`.AggregateRoot
import ru.smaliav.voting.common.`object`.IntegerEntityId
import ru.smaliav.voting.domain.vote.progress.stage.poll.VotePoll

class VoteProgressStage(
    val type: VoteProgressStageType,
    val pollId: VotePoll.Id,
): AggregateRoot<VoteProgressStage.Id>() {

    class Id(id: Int): IntegerEntityId(id)
}
