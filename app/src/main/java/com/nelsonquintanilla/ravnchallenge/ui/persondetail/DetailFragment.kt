package com.nelsonquintanilla.ravnchallenge.ui.persondetail

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.nelsonquintanilla.domain.model.Vehicle
import com.nelsonquintanilla.ravnchallenge.BR
import com.nelsonquintanilla.ravnchallenge.R
import com.nelsonquintanilla.ravnchallenge.databinding.FragmentDetailBinding
import com.nelsonquintanilla.ravnchallenge.ui.base.BaseFragment
import org.koin.android.ext.android.inject

/**
 * Shows the detail of a specific Star Wars person.
 */
class DetailFragment : BaseFragment<FragmentDetailBinding>(
    R.layout.fragment_detail,
    BR.viewModel
) {

    override val viewModel: DetailViewModel by inject()
    private val vehiclesAdapter: VehiclesAdapter by lazy { VehiclesAdapter() }
    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleUpButtonClick()
        setUpRecyclerView()
        setUiData()
    }

    private fun handleUpButtonClick() {
        binding().materialToolbar.setNavigationOnClickListener { view ->
            view.findNavController().navigateUp()
        }
    }

    private fun setUpRecyclerView() {
        binding().rvVehiclesList.apply {
            setItemDecorator(this)
            this.adapter = vehiclesAdapter
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

    private fun setUiData() {
        viewModel.personData.set(args.person)
        submitVehiclesList()
    }

    private fun submitVehiclesList() {
        vehiclesAdapter.submitList(getVehiclesList())
    }

    private fun getVehiclesList(): List<Vehicle> {
        val vehiclesList = mutableListOf<Vehicle>()
        args.person?.vehicleConnection?.vehicleList?.let { vehicles ->
            vehiclesList.addAll(vehicles)
        }
        return vehiclesList
    }
}
