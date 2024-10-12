package tech.pmenezes.starwars.repository

import org.springframework.data.jpa.repository.JpaRepository
import tech.pmenezes.starwars.model.PlanetEntity
import java.util.Optional

interface PlanetRepository: JpaRepository<PlanetEntity, Long> {

    fun findByName(name: String): Optional<PlanetEntity>
}