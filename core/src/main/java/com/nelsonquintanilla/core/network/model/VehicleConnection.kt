package com.nelsonquintanilla.core.network.model

import android.os.Parcel
import android.os.Parcelable

data class VehicleConnection(
    val vehicleList: List<Vehicle>? = null
) : Parcelable {

    constructor(parcel: Parcel) : this(parcel.createTypedArrayList(Vehicle))

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(vehicleList)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<VehicleConnection> {
        override fun createFromParcel(parcel: Parcel): VehicleConnection {
            return VehicleConnection(parcel)
        }

        override fun newArray(size: Int): Array<VehicleConnection?> {
            return arrayOfNulls(size)
        }
    }
}