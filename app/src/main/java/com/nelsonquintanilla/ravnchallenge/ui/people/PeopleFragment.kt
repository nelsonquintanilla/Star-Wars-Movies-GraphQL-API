package com.nelsonquintanilla.ravnchallenge.ui.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.nelsonquintanilla.data.network.model.HomeWorld
import com.nelsonquintanilla.data.network.model.Person
import com.nelsonquintanilla.data.network.model.Species
import com.nelsonquintanilla.data.network.model.Vehicle
import com.nelsonquintanilla.data.network.model.VehicleConnection
import com.nelsonquintanilla.ravnchallenge.R
import com.nelsonquintanilla.ravnchallenge.databinding.FragmentPeopleListBinding

/**
 * Shows the main screen which loads the list of People of Star Wars.
 */
class PeopleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPeopleListBinding.inflate(inflater, container, false)
        context ?: return binding.root

        setAdapter(binding.rvPeopleList)

        return binding.root
    }

    private fun setAdapter(recyclerView: RecyclerView) {
        val adapter = PeopleAdapter()
        setItemDecorator(recyclerView)
        recyclerView.adapter = adapter
        subscribeUi(adapter)
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

    private fun subscribeUi(adapter: PeopleAdapter) {
        adapter.submitList(generatePeopleList())
    }

    private fun generatePeopleList(): MutableList<Person> {
        val mockedPeopleList = mutableListOf<Person>()
        mockedPeopleList.add(
            Person(
                "cGVvcGxlOjE=",
                "Luke Skywalker",
                "blue",
                "blond",
                "fair",
                "19BBY",
                null,
                HomeWorld(
                    "cGxhbmV0czox",
                    "Tatooine"
                ),
                VehicleConnection(mutableListOf())
            )
        )
        mockedPeopleList.add(
            Person(
                "cGVvcGxlOjI=",
                "Luke Skywalker",
                "blue",
                "blond",
                "fair",
                "19BBY",
                Species(
                    "c3BlY2llczoy",
                    "Droid"
                ),
                HomeWorld(
                    "cGxhbmV0czox",
                    "Tatooine"
                ),
                VehicleConnection(generateVehiclesList())
            )
        )
        mockedPeopleList.add(
            Person(
                "cGVvcGxlOjM=",
                "Luke Skywalker",
                "blue",
                "blond",
                "fair",
                "19BBY",
                Species(
                    "c3BlY2llczoy",
                    "Droid"
                ),
                HomeWorld(
                    "cGxhbmV0czox",
                    "Tatooine"
                ),
                VehicleConnection(generateVehiclesList())
            )
        )
        mockedPeopleList.add(
            Person(
                "cGVvcGxlOjQ=",
                "Luke Skywalker",
                "blue",
                "blond",
                "fair",
                "19BBY",
                Species(
                    "c3BlY2llczoy",
                    "Droid"
                ),
                HomeWorld(
                    "cGxhbmV0czox",
                    "Tatooine"
                ),
                VehicleConnection(generateVehiclesList())
            )
        )
        mockedPeopleList.add(
            Person(
                "cGVvcGxlOjU=",
                "Luke Skywalker",
                "blue",
                "blond",
                "fair",
                "19BBY",
                Species(
                    "c3BlY2llczoy",
                    "Droid"
                ),
                HomeWorld(
                    "cGxhbmV0czox",
                    "Tatooine"
                ),
                VehicleConnection(generateVehiclesList())
            )
        )
        return mockedPeopleList
    }

    private fun generateVehiclesList(): MutableList<Vehicle> {
        val mockedVehicleList = mutableListOf<Vehicle>()
        mockedVehicleList.add(
            Vehicle(
                "dmVoaWNsZXM6MTQ=",
                "Snowspeeder"
            )
        )
        mockedVehicleList.add(
            Vehicle(
                "dmVoaWNsZXM6MzA=",
                "Imperial Speeder Bike"
            )
        )
        return mockedVehicleList
    }
}