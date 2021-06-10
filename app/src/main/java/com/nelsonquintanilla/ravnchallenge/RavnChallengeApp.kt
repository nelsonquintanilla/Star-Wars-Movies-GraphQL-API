package com.nelsonquintanilla.ravnchallenge

import android.app.Application
import com.nelsonquintanilla.data.common.di.coroutineModule
import com.nelsonquintanilla.data.common.di.networkingModule
import com.nelsonquintanilla.data.common.di.repositoryModule
import com.nelsonquintanilla.domain.di.interactionModule
import com.nelsonquintanilla.ravnchallenge.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class RavnChallengeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RavnChallengeApp)
            modules(loadModules())
        }
    }

    /**
     * Koin Modules getter function.
     * Used in the onCreate method by the Koin framework.
     * Open to be overridden by the Test Application class.
     *
     * @return listOf Koin Modules
     */
    open fun loadModules() = appModules + dataModules + domainModules + coroutineModules
}

val appModules = listOf(presentationModule)
val dataModules = listOf(repositoryModule, networkingModule)
val domainModules = listOf(interactionModule)
val coroutineModules = listOf(coroutineModule)