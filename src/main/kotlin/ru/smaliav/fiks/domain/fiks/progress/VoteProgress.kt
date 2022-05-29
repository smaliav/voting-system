package ru.smaliav.fiks.domain.fiks.progress

import ru.smaliav.fiks.common.`object`.AggregateRoot
import ru.smaliav.fiks.common.`object`.IntegerEntityId
import ru.smaliav.fiks.domain.fiks.progress.stage.ExpertStage
import ru.smaliav.fiks.domain.fiks.progress.stage.GroupStage
import ru.smaliav.fiks.domain.fiks.progress.stage.PublicStage

class VoteProgress: AggregateRoot<VoteProgress.Id>() {

    val state = VoteProgressState.CREATED
    private val stages = listOf(GroupStage(), ExpertStage(), PublicStage())
    var currentStage = stages.first()

    class Id(id: Int): IntegerEntityId(id)
}
