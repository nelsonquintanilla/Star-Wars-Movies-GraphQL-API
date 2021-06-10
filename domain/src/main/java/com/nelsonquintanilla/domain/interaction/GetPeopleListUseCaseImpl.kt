package com.nelsonquintanilla.domain.interaction

import com.nelsonquintanilla.domain.model.Person
import com.nelsonquintanilla.domain.model.util.Result
import com.nelsonquintanilla.domain.repository.PeopleRepository

class GetPeopleListUseCaseImpl(private val repository: PeopleRepository) : GetPeopleListUseCase {
    override suspend fun invoke(): Result<List<Person>> {
        return repository.getPeopleList()
    }
}