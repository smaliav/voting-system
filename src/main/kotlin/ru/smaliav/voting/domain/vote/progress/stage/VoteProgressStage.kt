package ru.smaliav.voting.domain.vote.progress.stage

import ru.smaliav.voting.common.`object`.AggregateRoot
import ru.smaliav.voting.common.`object`.IntegerEntityId
import ru.smaliav.voting.domain.vote.progress.VotePoll

abstract class VoteProgressStage(val stageType: FiksStageType): AggregateRoot<VoteProgressStage.Id>() {

    val poll = VotePoll()

    inner class Id(id: Int): IntegerEntityId(id)
}
