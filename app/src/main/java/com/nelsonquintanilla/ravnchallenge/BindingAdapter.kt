package com.nelsonquintanilla.ravnchallenge

import android.widget.TextView
import androidx.databinding.BindingAdapter
import org.apache.commons.text.WordUtils

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

    @JvmStatic
    @BindingAdapter("capitalizeFully")
    fun TextView.capitalizeFully(
        string: String?
    ) {
        string?.let {
            text = WordUtils.capitalizeFully(string)
        }
    }
}