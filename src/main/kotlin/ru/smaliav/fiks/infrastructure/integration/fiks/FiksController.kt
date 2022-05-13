package ru.smaliav.fiks.infrastructure.integration.fiks

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.smaliav.fiks.domain.fiks.Fiks
import ru.smaliav.fiks.infrastructure.persistence.domain.fiks.FiksRepository

@RequestMapping("/fiks")
@RestController
class FiksController @Autowired constructor(
    val fiksRepo: FiksRepository,
    val fiksService: FiksService,
) {

    @GetMapping("/{id}")
    fun getFiks(@PathVariable id: Int): Fiks {
        return fiksRepo.getById(id)
    }

    @PostMapping("/")
    fun createFiks(@RequestBody fiksDto: FiksDto): Fiks {
        return fiksService.createFiks(fiksDto)
    }

}