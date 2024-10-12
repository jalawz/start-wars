package tech.pmenezes.starwars.gateway

import feign.FeignException
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
import tech.pmenezes.starwars.client.SwapiClient

@Component
class PlanetsGateway(
    private val swapiClient: SwapiClient
) {

    fun getPlanetCount(name: String): Int {
        try {
            val planet = swapiClient.getPlanetByName(name)
            return if (planet.results.isEmpty()) 0 else planet.results.first().films.size
        } catch (ex: FeignException) {
            throw ResponseStatusException(HttpStatus.valueOf(ex.status()), ex.message)
        }
    }
}