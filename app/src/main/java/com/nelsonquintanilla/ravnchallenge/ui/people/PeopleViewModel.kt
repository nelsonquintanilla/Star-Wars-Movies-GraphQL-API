package com.nelsonquintanilla.ravnchallenge.ui.people

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import com.nelsonquintanilla.domain.interaction.GetPeopleListUseCase
import com.nelsonquintanilla.domain.model.Person
import com.nelsonquintanilla.domain.model.util.onFailure
import com.nelsonquintanilla.domain.model.util.onSuccess
import com.nelsonquintanilla.ravnchallenge.ui.base.BaseViewModel

class PeopleViewModel(
    private val getPeopleListUseCase: GetPeopleListUseCase
) : BaseViewModel() {

    val progressBarVisibility = ObservableBoolean(false)
    val errorMessageVisibility = ObservableBoolean(false)
    val peopleList = MutableLiveData<List<Person>>()
    var hasNextPage: Boolean = false
    var lastEndCursor: String? = null
    var isFirstLoad = true

    fun getPeopleList(cursor: String? = null) = executeUseCase {
        progressBarVisibility.set(true)
        getPeopleListUseCase(cursor)
            .onSuccess { allPeople ->
                allPeople.pageInfo?.let {
                    hasNextPage = it.hasNextPage ?: false
                    lastEndCursor = it.endCursor
                }
                peopleList.postValue(allPeople.people)
                checkForMoreData()
            }
            .onFailure {
                errorMessageVisibility.set(true)
            }
        progressBarVisibility.set(false)
    }

    private fun checkForMoreData() {
        if (hasNextPage) {
            getPeopleList(lastEndCursor)
        }
    }
}