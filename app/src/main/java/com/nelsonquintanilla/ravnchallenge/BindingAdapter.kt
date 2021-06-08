package com.nelsonquintanilla.ravnchallenge

import android.widget.TextView
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("speciesName", "homeWorldName")
    fun TextView.concatenateSpeciesNameAndHomeWorldName(
        speciesName: String?,
        homeWorldName: String?
    ) {
        text = if (speciesName.isNullOrEmpty()) {
            this.resources.getString(R.string.human_origin_label, homeWorldName)
        } else {
            this.resources.getString(R.string.species_origin_label, speciesName, homeWorldName)
        }
    }
}