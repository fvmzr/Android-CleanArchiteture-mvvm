package com.example.android_sample.features

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
class MovieView(val repository:String,  val Search: List<@RawValue SearchModel>, val totalResults:String) :Parcelable {

}