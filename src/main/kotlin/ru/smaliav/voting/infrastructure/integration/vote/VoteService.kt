package ru.smaliav.voting.infrastructure.integration.vote

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.smaliav.voting.domain.vote.Vote
import ru.smaliav.voting.domain.vote.VoteTarget
import ru.smaliav.voting.domain.vote.progress.VoteProgress
import ru.smaliav.voting.infrastructure.persistence.domain.vote.VoteRepository
import ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.VoteProgressRepository
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