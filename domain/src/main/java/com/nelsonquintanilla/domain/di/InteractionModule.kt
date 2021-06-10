package com.nelsonquintanilla.domain.di

import com.nelsonquintanilla.domain.interaction.GetPeopleListUseCase
import com.nelsonquintanilla.domain.interaction.GetPeopleListUseCaseImpl
import org.koin.dsl.module

val interactionModule = module {
    factory<GetPeopleListUseCase> { GetPeopleListUseCaseImpl(get()) }
}
