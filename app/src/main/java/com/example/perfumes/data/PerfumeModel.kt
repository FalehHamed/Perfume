package com.example.perfumes.data
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class PerfumeModel (
    val name: String,
    val image: Int,
    val brand: String,
    val price: Float
) : Parcelable