package com.nelsonquintanilla.ravnchallenge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nelsonquintanilla.core.network.model.Vehicle
import com.nelsonquintanilla.ravnchallenge.databinding.ListItemVehicleBinding

/**
 * Adapter for the [RecyclerView] in [DetailFragment].
 */
class VehicleAdapter : ListAdapter<Vehicle, RecyclerView.ViewHolder>(VehicleDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return VehicleViewHolder(
            ListItemVehicleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val vehicle = getItem(position)
        (holder as VehicleViewHolder).bind(vehicle)
    }

    class VehicleViewHolder(private val binding: ListItemVehicleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Vehicle) {
            binding.apply {
                vehicle = item
                executePendingBindings()
            }
        }
    }
}

private class VehicleDiffCallback : DiffUtil.ItemCallback<Vehicle>() {

    override fun areItemsTheSame(oldItem: Vehicle, newItem: Vehicle): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Vehicle, newItem: Vehicle): Boolean {
        return oldItem == newItem
    }
}