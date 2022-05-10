package ru.smaliav.fiks.infrastructure.integration.fiks

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.smaliav.fiks.infrastructure.persistence.domain.fiks.FiksRepository

@RequestMapping("/fiks")
@RestController
class FiksController @Autowired constructor(
    @Autowired val fiksRepo: FiksRepository,
) {

    @GetMapping("/{id}")
    fun getFiks(@PathVariable id: Int): ResponseEntity<String> {
        val fiks = fiksRepo.getById(id) ?: return ResponseEntity("Unlucky!", HttpStatus.NOT_FOUND)

        return ResponseEntity(
            "FIKS \"${fiks.name}\" expires in ${fiks.expires} ms", HttpStatus.OK
        )
    }

}