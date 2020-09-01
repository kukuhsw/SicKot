package com.hellu.lekot.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Galaxy(
    var planetName: String = "",
    var planetDetail: String = "",
    var photo: Int = 0
):Parcelable