package com.nelsonquintanilla.domain.interaction

import com.nelsonquintanilla.domain.model.AllPeople
import com.nelsonquintanilla.domain.model.util.Result
import com.nelsonquintanilla.domain.repository.PeopleRepository

class GetPeopleListUseCaseImpl(private val repository: PeopleRepository) : GetPeopleListUseCase {
    override suspend fun invoke(cursor: String?): Result<AllPeople> {
        return repository.getPeopleList(cursor)
    }
}