package com.nelsonquintanilla.ravnchallenge.ui.util

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.nelsonquintanilla.ravnchallenge.R
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

    @JvmStatic
    @BindingAdapter("visible")
    fun View.visible(visible: Boolean) {
        visibility = if (visible) View.VISIBLE else View.GONE
    }
}