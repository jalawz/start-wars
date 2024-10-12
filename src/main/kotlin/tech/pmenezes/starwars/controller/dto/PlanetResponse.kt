package tech.pmenezes.starwars.controller.dto

import tech.pmenezes.starwars.model.PlanetEntity

data class PlanetResponse(
    val id: Long,
    val name: String,
    val climate: String,
    val terrain: String,
    val appearancesQuantity: Int
) {
    fun toEntity() = PlanetEntity(
        id,
        name,
        climate,
        terrain,
        appearancesQuantity
    )
}
