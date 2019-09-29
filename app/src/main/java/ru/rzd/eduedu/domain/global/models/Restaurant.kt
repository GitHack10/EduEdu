package ru.rzd.eduedu.domain.global.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Restaurant(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("logo_img") val logo: String,
    @SerializedName("image_banner") val banner: String,
    @SerializedName("kitchen_type") val typeKitchen: String,
    @SerializedName("schedule") val schedule: String
): Parcelable