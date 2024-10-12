package tech.pmenezes.starwars.controller.dto

data class CreatePlanetRequest(
    val name: String,
    val climate: String,
    val terrain: String
)
