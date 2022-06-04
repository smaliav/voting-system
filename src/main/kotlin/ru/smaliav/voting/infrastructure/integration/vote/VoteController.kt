package ru.smaliav.voting.infrastructure.integration.vote

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.smaliav.voting.infrastructure.persistence.domain.vote.VoteRepository

@RequestMapping("/vote")
@RestController
class VoteController(
    val voteRepo: VoteRepository,
    val voteService: VoteService,
    val voteConverter: VoteDtoConverter,
) {

    @GetMapping("/{id}")
    fun getVote(@PathVariable id: Int): ResponseEntity<VoteDto> {
        val vote = voteRepo.getById(id)
        val voteDto = voteConverter.b2dto(vote)
        return ResponseEntity(voteDto, HttpStatus.OK)
    }

    @PostMapping("/")
    fun createVote(@RequestBody newVoteDto: NewVoteDto): ResponseEntity<VoteDto> {
        val vote = voteService.createVote(newVoteDto)
        val voteDto = voteConverter.b2dto(vote)
        return ResponseEntity(voteDto, HttpStatus.OK)
    }

}