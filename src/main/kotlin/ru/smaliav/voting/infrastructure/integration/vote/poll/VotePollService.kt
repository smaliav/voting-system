package ru.smaliav.voting.infrastructure.integration.vote.poll

import org.springframework.stereotype.Service
import ru.smaliav.voting.domain.vote.progress.stage.poll.VotePoll
import ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.stage.poll.VotePollRepository
import javax.transaction.Transactional

@Service
class VotePollService(
    private val pollRepo: VotePollRepository,
) {

    @Transactional
    fun vote(pollId: Int, voteDto: MadeVoteDto): VotePoll {
        val poll = pollRepo.getById(pollId)
        if (voteDto.agreed) {
            poll.agreed++
        } else {
            poll.rejected++
        }
        return pollRepo.save(poll)
    }

}