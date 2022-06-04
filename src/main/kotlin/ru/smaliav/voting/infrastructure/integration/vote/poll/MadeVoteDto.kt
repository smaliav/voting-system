package ru.smaliav.voting.infrastructure.integration.vote.poll

import com.fasterxml.jackson.annotation.JsonCreator

// Почему-то пришлось аннотировать через @JsonCreator
// Иначе получал ошибку при десериализации
/**
 * Голос пользователя в опросе
 */
data class MadeVoteDto @JsonCreator constructor(
    var agreed: Boolean,
)
