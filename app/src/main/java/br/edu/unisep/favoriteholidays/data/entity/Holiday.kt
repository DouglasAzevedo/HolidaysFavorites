package br.edu.unisep.favoriteholidays.data.entity

import androidx.room.Entity

@Entity(tableName = "holiday")
data class Holiday(
    var date: String,
    var name: String,
    var countryCode: String
)
