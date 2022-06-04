package ru.smaliav.voting.infrastructure.integration.vote.poll

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/poll")
@RestController
class PollController(
    private val pollService: VotePollService,
    private val pollConverter: VotePollDtoConverter,
) {

    @PostMapping("/{pollId}")
    fun vote(@PathVariable pollId: Int, @RequestBody voteDto: MadeVoteDto): ResponseEntity<VotePollDto> {
        val poll = pollService.vote(pollId, voteDto)
        val pollDto = pollConverter.b2dto(poll)
        return ResponseEntity(pollDto, HttpStatus.OK)
    }

}