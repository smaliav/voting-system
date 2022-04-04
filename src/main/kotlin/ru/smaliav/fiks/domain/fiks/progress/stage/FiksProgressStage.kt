package ru.smaliav.fiks.domain.fiks.progress.stage

import ru.smaliav.fiks.common.`object`.AggregateRoot
import ru.smaliav.fiks.common.`object`.IntegerEntityId
import ru.smaliav.fiks.domain.fiks.progress.FiksPoll

abstract class FiksProgressStage(val stageType: FiksStageType): AggregateRoot<FiksProgressStage.Id>() {

    val poll = FiksPoll()

    inner class Id: IntegerEntityId()
}
