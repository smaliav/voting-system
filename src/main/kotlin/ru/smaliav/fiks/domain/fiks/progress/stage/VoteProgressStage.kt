package ru.smaliav.fiks.domain.fiks.progress.stage

import ru.smaliav.fiks.common.`object`.AggregateRoot
import ru.smaliav.fiks.common.`object`.IntegerEntityId
import ru.smaliav.fiks.domain.fiks.progress.VotePoll

abstract class VoteProgressStage(val stageType: FiksStageType): AggregateRoot<VoteProgressStage.Id>() {

    val poll = VotePoll()

    inner class Id(id: Int): IntegerEntityId(id)
}
