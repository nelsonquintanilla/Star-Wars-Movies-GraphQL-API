package com.nelsonquintanilla.domain.interaction

import com.nelsonquintanilla.domain.model.AllPeople
import com.nelsonquintanilla.domain.model.util.Result

interface GetPeopleListUseCase {
    suspend operator fun invoke(cursor: String? = null): Result<AllPeople>
}