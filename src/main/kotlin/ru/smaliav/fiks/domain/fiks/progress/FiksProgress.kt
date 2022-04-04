package ru.smaliav.fiks.domain.fiks.progress

import ru.smaliav.fiks.common.`object`.AggregateRoot
import ru.smaliav.fiks.common.`object`.IntegerEntityId
import ru.smaliav.fiks.domain.fiks.progress.stage.ExpertStage
import ru.smaliav.fiks.domain.fiks.progress.stage.GroupStage
import ru.smaliav.fiks.domain.fiks.progress.stage.PublicStage

class FiksProgress: AggregateRoot<FiksProgress.Id>() {

    val state = FiksProgressState.CREATED
    private val stages = listOf(GroupStage(), ExpertStage(), PublicStage())
    val currentStage = stages.first()

    inner class Id: IntegerEntityId()
}
