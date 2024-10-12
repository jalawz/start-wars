package tech.pmenezes.starwars.client.dto

data class PlanetsResponse(
    val count: Int,
    val results: List<PlanetResult>
)

data class PlanetResult(
    val name: String,
    val films: List<String>
)