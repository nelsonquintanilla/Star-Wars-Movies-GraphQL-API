package com.nelsonquintanilla.domain.repository

import com.nelsonquintanilla.domain.model.Person
import com.nelsonquintanilla.domain.model.util.Result

interface PeopleRepository {
    suspend fun getPeopleList(): Result<List<Person>>
}