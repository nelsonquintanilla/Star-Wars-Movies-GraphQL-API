package com.nelsonquintanilla.domain.model

import android.os.Parcel
import android.os.Parcelable

data class HomeWorld(
    val id: String? = null,
    val homeWorldName: String? = null
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(homeWorldName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HomeWorld> {
        override fun createFromParcel(parcel: Parcel): HomeWorld {
            return HomeWorld(parcel)
        }

        override fun newArray(size: Int): Array<HomeWorld?> {
            return arrayOfNulls(size)
        }
    }
}