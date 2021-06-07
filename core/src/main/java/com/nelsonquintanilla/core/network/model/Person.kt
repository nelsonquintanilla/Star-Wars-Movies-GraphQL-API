package com.nelsonquintanilla.core.network.model

data class Person(
    val id: String? = null,
    val name: String? = null,
    val eyeColor: String? = null,
    val hairColor: String? = null,
    val skinColor: String? = null,
    val birthYear: String? = null,
    val species: Species? = null,
    val homeWorld: HomeWorld? = null,
    val vehicleConnection: VehicleConnection? = null
)
