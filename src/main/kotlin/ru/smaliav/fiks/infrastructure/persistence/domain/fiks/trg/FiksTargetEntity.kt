package ru.smaliav.fiks.infrastructure.persistence.domain.fiks.trg

import javax.persistence.*

@Table(name = "fiks_target")
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
