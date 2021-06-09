package com.nelsonquintanilla.data.network.model

import android.os.Parcel
import android.os.Parcelable

data class Person(
    val id: String? = null,
    val name: String? = null,
    val eyeColor: String? = null,
    val hairColor: String? = null,
    val skinColor: String? = null,
    val birthYear: String? = null,
    val species: Species? = null,
    val homeWorld: HomeWorld? = null,
    val vehicleConnection: VehicleConnection? = null
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Species::class.java.classLoader),
        parcel.readParcelable(HomeWorld::class.java.classLoader),
        parcel.readParcelable(VehicleConnection::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(eyeColor)
        parcel.writeString(hairColor)
        parcel.writeString(skinColor)
        parcel.writeString(birthYear)
        parcel.writeParcelable(species, flags)
        parcel.writeParcelable(homeWorld, flags)
        parcel.writeParcelable(vehicleConnection, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }
}
