package com.nelsonquintanilla.ravnchallenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.nelsonquintanilla.ravnchallenge.databinding.FragmentDetailBinding

/**
 * Shows the detail of a specific Star Wars person.
 */
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDetailBinding.inflate(inflater, container, false)
        context ?: return binding.root

        setAdapter(binding.rvVehiclesList)

        return binding.root
    }

    private fun setAdapter(recyclerView: RecyclerView) {
        val adapter = VehicleAdapter()
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

    private fun subscribeUi(adapter: VehicleAdapter) {
        //adapter.submitList()
    }
}