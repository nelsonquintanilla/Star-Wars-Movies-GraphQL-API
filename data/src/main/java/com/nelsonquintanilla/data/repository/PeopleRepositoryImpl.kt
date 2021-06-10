package com.nelsonquintanilla.data.repository

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloException
import com.nelsonquintanilla.data.networking.PeopleListQuery
import com.nelsonquintanilla.domain.model.AllPeople
import com.nelsonquintanilla.domain.model.HomeWorld
import com.nelsonquintanilla.domain.model.PageInfo
import com.nelsonquintanilla.domain.model.Person
import com.nelsonquintanilla.domain.model.Species
import com.nelsonquintanilla.domain.model.Vehicle
import com.nelsonquintanilla.domain.model.VehicleConnection
import com.nelsonquintanilla.domain.model.util.Failure
import com.nelsonquintanilla.domain.model.util.HttpError
import com.nelsonquintanilla.domain.model.util.Result
import com.nelsonquintanilla.domain.model.util.Success
import com.nelsonquintanilla.domain.repository.PeopleRepository

class PeopleRepositoryImpl(
    private val apolloClient: ApolloClient
) : PeopleRepository {

    override suspend fun getPeopleList(
        cursor: String?
    ): Result<AllPeople> {
        return try {
            val data = apolloClient.query(
                PeopleListQuery(
                    size = Input.fromNullable(LIST_SIZE),
                    cursor = Input.fromNullable(cursor)
                )
            ).await()

            val allPeople: AllPeople
            val peopleList = mutableListOf<Person>()
            var pageInfo = PageInfo()

            data.data?.allPeople?.pageInfo?.let {
                pageInfo = PageInfo(
                    hasNextPage = it.hasNextPage,
                    hasPreviousPage = it.hasPreviousPage,
                    startCursor = it.startCursor,
                    endCursor = it.endCursor
                )
            }

            data.data?.allPeople?.people?.forEach { person ->
                val vehiclesList = mutableListOf<Vehicle>()
                person?.vehicleConnection?.vehicles?.forEach { vehicle ->
                    vehiclesList.add(
                        Vehicle(
                            vehicle?.id,
                            vehicle?.name
                        )
                    )
                }

                val personItem = Person(
                    id = person?.id,
                    name = person?.name,
                    eyeColor = person?.eyeColor,
                    hairColor = person?.hairColor,
                    skinColor = person?.skinColor,
                    birthYear = person?.birthYear,
                    species = Species(
                        person?.species?.id,
                        person?.species?.name
                    ),
                    homeWorld = HomeWorld(
                        person?.homeworld?.id,
                        person?.homeworld?.name
                    ),
                    vehicleConnection = VehicleConnection(
                        vehiclesList
                    )
                )
                peopleList.add(personItem)
            }

            allPeople = AllPeople(
                people = peopleList,
                pageInfo = pageInfo
            )

            Success(allPeople)
        } catch (ex: ApolloException) {
            Failure(HttpError(ex, ERROR_CODE))
        }
    }

    companion object {
        const val ERROR_CODE = 500
        const val LIST_SIZE = 5
    }
}