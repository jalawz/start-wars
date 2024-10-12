package tech.pmenezes.starwars.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import tech.pmenezes.starwars.controller.dto.PlanetResponse

@Entity
@Table(name = "planets")
data class PlanetEntity(
    @Id
    @GeneratedValue
    @Column(name = "planet_id")
    val planetId: Long? = null,
    val name: String,
    val climate: String,
    val terrain: String,
    val quantity: Int
) {
    fun toResponse() = PlanetResponse(
        planetId!!,
        name,
        climate,
        terrain,
        quantity
    )
}
