package ru.smaliav.voting.infrastructure.integration.vote.progress

import org.springframework.stereotype.Component
import ru.smaliav.voting.domain.vote.progress.VoteProgress
import ru.smaliav.voting.infrastructure.integration.vote.progress.stage.VoteProgressStageDtoConverter
import ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.stage.VoteProgressStageRepository

@Component
class VoteProgressDtoConverter(
    private val stageRepo: VoteProgressStageRepository,
    private val stageConverter: VoteProgressStageDtoConverter,
) {

    fun b2dto(business: VoteProgress): VoteProgressDto {
        val groupStage = stageRepo.getById(business.groupStageId)
        val expertStage = if (business.expertStageId != null) stageRepo.getById(business.expertStageId!!) else null
        val publicStage = if (business.publicStageId != null) stageRepo.getById(business.publicStageId!!) else null

        val groupStageDto = stageConverter.b2dto(groupStage)
        val expertStageDto = if (expertStage != null) stageConverter.b2dto(expertStage) else null
        val publicStageDto = if (publicStage != null) stageConverter.b2dto(publicStage) else null

        return VoteProgressDto(
            business.state,
            groupStageDto,
            expertStageDto,
            publicStageDto,
        )
    }

}