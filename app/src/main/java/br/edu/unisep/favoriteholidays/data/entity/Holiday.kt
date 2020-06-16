package br.edu.unisep.favoriteholidays.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "holiday")
data class Holiday(
    var date: String,
    var name: String,
    var countryCode: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
