package com.nelsonquintanilla.ravnchallenge.ui.persondetail

import androidx.databinding.ObservableField
import com.nelsonquintanilla.domain.model.Person
import com.nelsonquintanilla.ravnchallenge.ui.base.BaseViewModel

class DetailViewModel : BaseViewModel() {
    val personData = ObservableField<Person>()
}