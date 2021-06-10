package com.nelsonquintanilla.ravnchallenge.ui.people

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.nelsonquintanilla.domain.model.Person
import com.nelsonquintanilla.ravnchallenge.BR
import com.nelsonquintanilla.ravnchallenge.R
import com.nelsonquintanilla.ravnchallenge.databinding.FragmentPeopleListBinding
import com.nelsonquintanilla.ravnchallenge.ui.base.BaseFragment
import org.koin.android.ext.android.inject

/**
 * Shows the main screen which loads the list of People of Star Wars.
 */
class PeopleFragment : BaseFragment<FragmentPeopleListBinding>(
    R.layout.fragment_people_list,
    BR.viewModel
) {

    override val viewModel: PeopleViewModel by inject()
    private val peopleAdapter: PeopleAdapter by lazy { PeopleAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        viewModel.apply {
            if (isFirstLoad) {
                isFirstLoad = false
                peopleList.observe(viewLifecycleOwner, peopleListObserver())
                getPeopleList()
            }
        }
    }

    private fun peopleListObserver() = Observer<List<Person>> { peopleList ->
        val cumulativePeopleList = mutableListOf<Person>()
        cumulativePeopleList.addAll(peopleAdapter.currentList)
        cumulativePeopleList.addAll(peopleList)
        peopleAdapter.submitList(cumulativePeopleList)
    }

    private fun setUpRecyclerView() {
        binding().rvPeopleList.apply {
            setItemDecorator(this)
            this.adapter = peopleAdapter
        }
    }

    private fun setItemDecorator(recyclerView: RecyclerView) {
        recyclerView.apply {
            val dividerItemDecorator =
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            ContextCompat.getDrawable(requireContext(), R.drawable.sh_divider_container)?.let {
                dividerItemDecorator.setDrawable(it)
            }
            addItemDecoration(dividerItemDecorator)
        }
    }
}