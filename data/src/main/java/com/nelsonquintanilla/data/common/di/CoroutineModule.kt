package com.nelsonquintanilla.data.common.di

import com.nelsonquintanilla.data.common.coroutine.CoroutineContextProvider
import org.koin.dsl.module

val coroutineModule = module {
    single { CoroutineContextProvider() }
}