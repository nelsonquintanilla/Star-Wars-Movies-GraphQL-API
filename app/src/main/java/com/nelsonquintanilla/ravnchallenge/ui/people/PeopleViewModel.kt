package com.nelsonquintanilla.ravnchallenge.ui.people

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import com.nelsonquintanilla.domain.interaction.GetPeopleListUseCase
import com.nelsonquintanilla.domain.model.Person
import com.nelsonquintanilla.domain.model.util.onFailure
import com.nelsonquintanilla.domain.model.util.onSuccess
import com.nelsonquintanilla.ravnchallenge.ui.base.BaseViewModel
import com.nelsonquintanilla.ravnchallenge.ui.util.Event

class PeopleViewModel(
    private val getPeopleListUseCase: GetPeopleListUseCase
) : BaseViewModel() {

    var responseEvent = MutableLiveData<Event<String>>()
    val progressBarVisibility = ObservableBoolean(false)
    val errorMessageVisibility = ObservableBoolean(false)
    val peopleList = MutableLiveData<List<Person>>()

    fun getPeopleList() = executeUseCase {
        progressBarVisibility.set(true)
        getPeopleListUseCase()
            .onSuccess {
                peopleList.postValue(it)
            }
            .onFailure {
                errorMessageVisibility.set(true)
            }
        progressBarVisibility.set(false)
    }
}