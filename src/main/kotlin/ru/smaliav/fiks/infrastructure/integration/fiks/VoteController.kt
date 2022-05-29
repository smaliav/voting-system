package ru.smaliav.fiks.infrastructure.integration.fiks

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.smaliav.fiks.domain.fiks.Vote
import ru.smaliav.fiks.infrastructure.persistence.domain.fiks.VoteRepository

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