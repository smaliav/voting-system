package ru.smaliav.voting.infrastructure.integration.base.converter

interface DtoToBusinessConverter<DTO, B> {
    fun dto2b(dto: DTO): B
    fun b2dto(business: B): DTO
}