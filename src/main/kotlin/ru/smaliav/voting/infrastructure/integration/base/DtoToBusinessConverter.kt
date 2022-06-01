package ru.smaliav.voting.infrastructure.integration.base

// TODO Проверить, что все DTO-to-Business конвертеры реализуют этот интерфейс
interface DtoToBusinessConverter<DTO, B> {
    fun dto2b(dto: DTO): B
    fun b2dto(business: B): DTO
}