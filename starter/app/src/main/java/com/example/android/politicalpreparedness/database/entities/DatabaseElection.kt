package com.example.android.politicalpreparedness.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.politicalpreparedness.network.models.Division
import com.example.android.politicalpreparedness.network.models.Election
import com.squareup.moshi.Json
import java.util.*

@Entity(tableName = "election_table")
data class DatabaseElection(
        @PrimaryKey val id: Int,
        @ColumnInfo(name = "name") val name: String,
        @ColumnInfo(name = "electionDay") val electionDay: Date,
        @Embedded(prefix = "division_") @Json(name = "ocdDivisionId") val division: Division
)

fun List<DatabaseElection>.asDomainModel(): List<Election> {
    return map {
        Election(
                id = it.id,
                name = it.name,
                electionDay = it.electionDay,
                division = it.division
        )
    }
}