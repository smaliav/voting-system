package ru.smaliav.voting.infrastructure.persistence.domain.vote.trg

import javax.persistence.*

@Table(name = "vote_target")
@Entity
class FiksTargetEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int,

    @Column(name = "name")
    val name: String,

    @Column(name = "code")
    val code: String,

)
