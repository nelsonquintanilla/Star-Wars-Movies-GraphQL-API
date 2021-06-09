package com.nelsonquintanilla.ravnchallenge.ui.persondetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.nelsonquintanilla.data.network.model.Vehicle
import com.nelsonquintanilla.ravnchallenge.R
import com.nelsonquintanilla.ravnchallenge.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Shows the detail of a specific Star Wars person.
 */
@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val detailViewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDetailBinding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.viewModel = detailViewModel
        handleUpButtonClick(binding.materialToolbar)
        setUiData()
        setVehicleAdapter(binding.rvVehiclesList)

        return binding.root
    }

    private fun handleUpButtonClick(materialToolbar: MaterialToolbar) {
        materialToolbar.setNavigationOnClickListener { view ->
            view.findNavController().navigateUp()
        }
    }

    private fun setUiData() {
        detailViewModel.personData.set(args.person)
    }

    private fun setVehicleAdapter(recyclerView: RecyclerView) {
        val adapter = VehiclesAdapter()
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

    private fun subscribeUi(adapter: VehiclesAdapter) {
        adapter.submitList(getVehiclesList())
    }

    private fun getVehiclesList(): List<Vehicle> {
        val vehiclesList = mutableListOf<Vehicle>()
        args.person?.vehicleConnection?.vehicleList?.let { vehicles ->
            vehiclesList.addAll(vehicles)
        }
        return vehiclesList
    }
}
