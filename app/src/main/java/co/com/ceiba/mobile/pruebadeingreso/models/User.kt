package co.com.ceiba.mobile.pruebadeingreso.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class User(
    @PrimaryKey
    val id: Int,
    val name: String?,
    val username: String?,
    val email: String?,
    val phone: String?,
    val website: String?
) : Parcelable