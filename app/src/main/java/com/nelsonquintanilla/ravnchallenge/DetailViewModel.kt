package com.nelsonquintanilla.ravnchallenge

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.nelsonquintanilla.core.network.model.Person
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() : ViewModel() {
    var personData = ObservableField<Person>()
}