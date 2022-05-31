package ru.smaliav.voting.domain.vote.progress

import ru.smaliav.voting.common.`object`.AggregateRoot
import ru.smaliav.voting.common.`object`.IntegerEntityId
import ru.smaliav.voting.domain.vote.progress.stage.ExpertStage
import ru.smaliav.voting.domain.vote.progress.stage.GroupStage
import ru.smaliav.voting.domain.vote.progress.stage.PublicStage

class VoteProgress: AggregateRoot<VoteProgress.Id>() {

    val state = VoteProgressState.CREATED
    private val stages = listOf(GroupStage(), ExpertStage(), PublicStage())
    var currentStage = stages.first()

    class Id(id: Int): IntegerEntityId(id)
}
