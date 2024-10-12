package tech.pmenezes.starwars.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tech.pmenezes.starwars.controller.dto.CreatePlanetRequest
import tech.pmenezes.starwars.controller.dto.PlanetResponse
import tech.pmenezes.starwars.usecase.PlanetUseCase
import java.net.URI

@RestController
@RequestMapping("/planets")
class PlanetController(
    private val planetUseCase: PlanetUseCase
) {

    @PostMapping
    fun createPlanet(@RequestBody request: CreatePlanetRequest): ResponseEntity<PlanetResponse> {
        val response = planetUseCase.createPlanet(request)
        return ResponseEntity.created(URI.create("/planets/${response.id}")).build()
    }

    @GetMapping
    fun listPlanets(
        @RequestParam("name", required = false) name: String?
    ): ResponseEntity<List<PlanetResponse>> {

        val planetsResponse = planetUseCase.listPlanets(name?: "")
        return ResponseEntity.ok(planetsResponse)
    }

    @GetMapping("/{planetId}")
    fun getByNameOrId(@PathVariable planetId: Long): ResponseEntity<PlanetResponse> {
        val response = planetUseCase.getPlanetById(planetId)

        return ResponseEntity.ok(response)
    }

    @DeleteMapping("{planetId}")
    fun deletePlanet(@PathVariable("planetId") planetId: Long): ResponseEntity<Void> {
        planetUseCase.deletePlanet(planetId)
        return ResponseEntity.noContent().build()
    }
}