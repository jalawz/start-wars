package tech.pmenezes.starwars.usecase

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
import tech.pmenezes.starwars.controller.dto.CreatePlanetRequest
import tech.pmenezes.starwars.controller.dto.PlanetResponse
import tech.pmenezes.starwars.gateway.PlanetsGateway
import tech.pmenezes.starwars.model.PlanetEntity
import tech.pmenezes.starwars.repository.PlanetRepository

@Component
class PlanetUseCase(
    private val planetsGateway: PlanetsGateway,
    private val planetRepository: PlanetRepository
) {

    fun createPlanet(request: CreatePlanetRequest): PlanetResponse {
        val quantity = planetsGateway.getPlanetCount(request.name)

        val savedPlanet = planetRepository.save(PlanetEntity(
            name = request.name,
            climate = request.climate,
            terrain = request.terrain,
            quantity = quantity
        ))

        return savedPlanet.toResponse()
    }

    fun listPlanets(name: String): List<PlanetResponse> {
        if (name.isEmpty()) {
            return planetRepository.findAll().map { it.toResponse() }
        }

        val planet = planetRepository.findByName(name).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "Planet with name: $name not found")
        }
        return listOf(planet.toResponse())
    }


    fun getPlanetById(planetId: Long): PlanetResponse {
        return findById(planetId).toResponse()
    }

    fun deletePlanet(id: Long) {
        val planet = findById(id)
        planetRepository.delete(planet)
    }

    private fun findById(id: Long): PlanetEntity {
        return planetRepository.findById(id).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "Planet with id: $id not found")
        }
    }

    private fun isNumeric(value: String): Boolean {
        return value.toIntOrNull() != null
    }
}