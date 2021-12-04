package co.com.ceiba.mobile.pruebadeingreso.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Geo(
    val lat: String?,
    val lng: String?
) : Parcelable