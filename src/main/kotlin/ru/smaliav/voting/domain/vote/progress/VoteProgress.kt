package ru.smaliav.voting.domain.vote.progress

import ru.smaliav.voting.common.`object`.AggregateRoot
import ru.smaliav.voting.common.`object`.IntegerEntityId
import ru.smaliav.voting.domain.vote.progress.stage.VoteProgressStage

class VoteProgress(
    val groupStageId: VoteProgressStage.Id,
): AggregateRoot<VoteProgress.Id>() {

    var expertStageId: VoteProgressStage.Id? = null
    var publicStageId: VoteProgressStage.Id? = null
    var state = VoteProgressState.CREATED

    // Конструктор для конвертации
    constructor(
        id: Id,
        groupStageId: VoteProgressStage.Id,
        expertStageId: VoteProgressStage.Id?,
        publicStageId: VoteProgressStage.Id?,
        state: VoteProgressState,
    ) : this(groupStageId) {
        this.id = id
        this.expertStageId = expertStageId
        this.publicStageId = publicStageId
        this.state = state
    }

    class Id(id: Int): IntegerEntityId(id)
}
