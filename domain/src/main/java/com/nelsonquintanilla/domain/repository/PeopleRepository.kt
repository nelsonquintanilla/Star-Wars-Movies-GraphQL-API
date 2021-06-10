package com.nelsonquintanilla.domain.repository

import com.nelsonquintanilla.domain.model.AllPeople
import com.nelsonquintanilla.domain.model.Person
import com.nelsonquintanilla.domain.model.util.Result

interface PeopleRepository {
    suspend fun getPeopleList(
        cursor: String?
    ): Result<AllPeople>
}