package br.edu.unisep.favoriteholidays.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.edu.unisep.favoriteholidays.data.entity.Holiday

@Dao
interface HolidayDao {

    @Insert
    suspend fun save(holiday : Holiday)

    @Query("select * from holiday")
    suspend fun findAll(): List<Holiday>

    @Query("DELETE FROM holiday WHERE name = :name")
    suspend fun deleteByName(name: String)

}