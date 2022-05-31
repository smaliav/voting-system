package ru.smaliav.voting.infrastructure.persistence.domain.vote

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.smaliav.voting.domain.vote.Vote
import ru.smaliav.voting.domain.vote.VoteTarget
import ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.VoteProgressConverter
import ru.smaliav.voting.infrastructure.persistence.domain.vote.trg.VoteTargetConverter

@Service
class VoteConverter @Autowired constructor(
    private val targetConverter: VoteTargetConverter,
    private val progressConverter: VoteProgressConverter,
) {

    fun e2b(entity: VoteEntity): Vote {
        val res = Vote(
            entity.name,
            entity.expires,
            VoteTarget.Id(entity.target.id),
            progressConverter.eid2bid(entity.progress.id),
            entity.created,
        )
        res.id = Vote.Id(entity.id!!)
        res.description = entity.description

        return res
    }

    fun b2e(business: Vote): VoteEntity {
        return VoteEntity(
            business.id?.value,
            business.name,
            business.expires,
            business.created,
            business.description,
            targetConverter.bid2e(business.targetId),
            progressConverter.bid2e(business.progressId),
        )
    }

}