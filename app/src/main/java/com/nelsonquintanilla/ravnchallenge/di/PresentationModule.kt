package com.nelsonquintanilla.ravnchallenge.di

import com.nelsonquintanilla.ravnchallenge.ui.people.PeopleViewModel
import com.nelsonquintanilla.ravnchallenge.ui.persondetail.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    // ViewModels
    viewModel {
        PeopleViewModel(
            get()
        )
    }

    viewModel {
        DetailViewModel()
    }
}