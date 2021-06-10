package com.nelsonquintanilla.data.common.di

import com.nelsonquintanilla.data.repository.PeopleRepositoryImpl
import com.nelsonquintanilla.domain.repository.PeopleRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {

    factory<PeopleRepository> {
        PeopleRepositoryImpl(
            apolloClient = get(named(APOLLO_INSTANCE_NAME))
        )
    }
}
