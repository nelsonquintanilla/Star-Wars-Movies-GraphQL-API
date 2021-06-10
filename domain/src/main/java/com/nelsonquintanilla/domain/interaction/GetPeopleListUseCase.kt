package com.nelsonquintanilla.domain.interaction

import com.nelsonquintanilla.domain.model.Person
import com.nelsonquintanilla.domain.model.util.Result

interface GetPeopleListUseCase {
    suspend operator fun invoke(): Result<List<Person>>
}