package com.nelsonquintanilla.core.network.model

import android.os.Parcel
import android.os.Parcelable

data class Species(
    val id: String? = null,
    val speciesName: String? = null
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(speciesName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Species> {
        override fun createFromParcel(parcel: Parcel): Species {
            return Species(parcel)
        }

        override fun newArray(size: Int): Array<Species?> {
            return arrayOfNulls(size)
        }
    }
}