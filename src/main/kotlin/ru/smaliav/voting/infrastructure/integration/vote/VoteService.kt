package ru.smaliav.voting.infrastructure.integration.vote

import org.springframework.stereotype.Service
import ru.smaliav.voting.domain.vote.Vote
import ru.smaliav.voting.domain.vote.VoteTarget
import ru.smaliav.voting.domain.vote.chat.VoteChat
import ru.smaliav.voting.domain.vote.progress.VoteProgress
import ru.smaliav.voting.domain.vote.progress.stage.VoteProgressStage
import ru.smaliav.voting.domain.vote.progress.stage.VoteProgressStageType
import ru.smaliav.voting.domain.vote.progress.stage.poll.VotePoll
import ru.smaliav.voting.infrastructure.integration.exception.InvalidNullException
import ru.smaliav.voting.infrastructure.persistence.domain.vote.VoteRepository
import ru.smaliav.voting.infrastructure.persistence.domain.vote.chat.VoteChatRepository
import ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.VoteProgressRepository
import ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.stage.VoteProgressStageRepository
import ru.smaliav.voting.infrastructure.persistence.domain.vote.progress.stage.poll.VotePollRepository
import javax.transaction.Transactional

@Service
class VoteService(
    private val voteRepo: VoteRepository,
    private val progressRepo: VoteProgressRepository,
    private val chatRepo: VoteChatRepository,
    private val stageRepo: VoteProgressStageRepository,
    private val pollRepo: VotePollRepository,
) {

    @Transactional
    fun createVote(voteDto: VoteDto): Vote {
        val vote = Vote(
            voteDto.name,
            voteDto.expires,
            VoteTarget.Id(voteDto.targetId),
            createVoteProgress(),
            createVoteChat(voteDto.name)
        )
        vote.description = voteDto.description

        return voteRepo.save(vote)
    }

    fun createVoteProgress(): VoteProgress.Id {
        val progress = VoteProgress(createGroupStage())
        return progressRepo.save(progress)
    }

    fun createGroupStage(): VoteProgressStage.Id {
        var groupStage = VoteProgressStage(VoteProgressStageType.GROUP, createPoll())
        groupStage = stageRepo.save(groupStage)
        return groupStage.id ?: throw InvalidNullException()
    }

    fun createPoll(): VotePoll.Id {
        var poll = VotePoll()
        poll = pollRepo.save(poll)
        return poll.id ?: throw InvalidNullException()
    }

    fun createVoteChat(voteName: String): VoteChat.Id {
        var chat = VoteChat(voteName)
        chat = chatRepo.save(chat)
        return chat.id ?: throw InvalidNullException()
    }

}