package com.empirox.pokedex.model

data class Pokemon (
    val id:Int,
    val name:String,
    val life:Int,
    val attack:Int,
    val defense:Int,
    val speed:Int,
    val type:PokemonType,
    val url:String
)
enum class PokemonType {
    FUEGO,
    PLANTA,
    AGUA,
    LUCHA,
    ELECTRICO
}