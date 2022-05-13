package ru.smaliav.fiks.infrastructure.persistence.domain.fiks

import ru.smaliav.fiks.infrastructure.persistence.domain.fiks.trg.FiksTargetEntity
import java.time.Instant
import javax.persistence.*

@Table(name = "fiks")
@Entity
class FiksEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int?,

    @Column(name = "name")
    val name: String,

    @Column(name = "expires")
    val expires: Long,

    @Column(name = "created")
    val created: Instant,

    @Column(name = "description")
    val description: String,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [ CascadeType.ALL ])
    @JoinColumn(name = "target")
    val target: FiksTargetEntity

)
