package com.example.android.politicalpreparedness.network.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Election(
        val id: Int,
        val name: String,
        val electionDay: Date,
        val division: Division
) : Parcelable
