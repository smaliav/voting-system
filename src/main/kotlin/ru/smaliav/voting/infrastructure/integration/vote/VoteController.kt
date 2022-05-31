package ru.smaliav.voting.infrastructure.integration.vote

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.smaliav.voting.domain.vote.Vote
import ru.smaliav.voting.infrastructure.persistence.domain.vote.VoteRepository

@RequestMapping("/vote")
@RestController
class VoteController @Autowired constructor(
    val fiksRepo: VoteRepository,
    val voteService: VoteService,
) {

    @GetMapping("/{id}")
    fun getFiks(@PathVariable id: Int): Vote {
        return fiksRepo.getById(id)
    }

    @PostMapping("/")
    fun createFiks(@RequestBody voteDto: VoteDto): Vote {
        return voteService.createVote(voteDto)
    }

}