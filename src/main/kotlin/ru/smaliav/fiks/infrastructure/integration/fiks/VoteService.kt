package ru.smaliav.fiks.infrastructure.integration.fiks

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.smaliav.fiks.domain.fiks.Vote
import ru.smaliav.fiks.domain.fiks.VoteTarget
import ru.smaliav.fiks.domain.fiks.progress.VoteProgress
import ru.smaliav.fiks.infrastructure.persistence.domain.fiks.VoteRepository
import ru.smaliav.fiks.infrastructure.persistence.domain.fiks.progress.VoteProgressRepository
import javax.transaction.Transactional

@Service
class VoteService @Autowired constructor(
    private val voteRepo: VoteRepository,
    private val progressRepo: VoteProgressRepository,
) {

    @Transactional
    fun createVote(voteDto: VoteDto): Vote {
        val vote = Vote(
            voteDto.name,
            voteDto.expires,
            VoteTarget.Id(voteDto.targetId),
            createVoteProgress()
        )
        vote.description = voteDto.description

        return voteRepo.save(vote)
    }

    @Transactional
    fun createVoteProgress(): VoteProgress.Id {
        val progress = VoteProgress()
        return progressRepo.save(progress)
    }

}