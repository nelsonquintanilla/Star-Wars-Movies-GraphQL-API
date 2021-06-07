package com.nelsonquintanilla.ravnchallenge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nelsonquintanilla.core.network.model.Person
import com.nelsonquintanilla.ravnchallenge.databinding.ListItemPersonBinding

/**
 * Adapter for the [RecyclerView] in [PeopleFragment].
 */
class PeopleAdapter : ListAdapter<Person, RecyclerView.ViewHolder>(PersonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PersonViewHolder(
            ListItemPersonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val person = getItem(position)
        (holder as PersonViewHolder).bind(person)
    }

    class PersonViewHolder(private val binding: ListItemPersonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Person) {
            binding.apply {
                person = item
                executePendingBindings()
            }
        }
    }
}

private class PersonDiffCallback : DiffUtil.ItemCallback<Person>() {

    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem == newItem
    }
}