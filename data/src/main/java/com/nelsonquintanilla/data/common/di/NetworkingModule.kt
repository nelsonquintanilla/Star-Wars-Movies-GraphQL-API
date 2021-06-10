package com.nelsonquintanilla.data.common.di

import com.apollographql.apollo.ApolloClient
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val APOLLO_INSTANCE_NAME = "apollo_instance_name"
const val SERVER_URL = "https://swapi-graphql.netlify.app/.netlify/functions/index"

val networkingModule = module {

    single(named(APOLLO_INSTANCE_NAME)) {
        ApolloClient.builder()
            .serverUrl(SERVER_URL)
            .build()
    }
}
