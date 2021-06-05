package com.nelsonquintanilla.ravnchallenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.nelsonquintanilla.ravnchallenge.databinding.FragmentStarWarsPeopleBinding

/**
 * Shows the main screen which loads the list of People of Star Wars.
 */
class StarWarsPeopleFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = DataBindingUtil.inflate<FragmentStarWarsPeopleBinding>(
            inflater,
            R.layout.fragment_star_wars_people,
            container,
            false
        )

        return binding.root
    }
}