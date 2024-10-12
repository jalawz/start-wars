package tech.pmenezes.starwars.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import tech.pmenezes.starwars.client.dto.PlanetsResponse

@FeignClient(
    name = "swapi-client",
    url = "\${swapi.url}"
)
interface SwapiClient {

    @GetMapping("/planets")
    fun getPlanetByName(
        @RequestParam("search", required = true) search: String
    ): PlanetsResponse
}