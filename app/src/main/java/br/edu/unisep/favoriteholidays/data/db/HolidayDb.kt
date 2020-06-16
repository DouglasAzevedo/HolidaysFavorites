package br.edu.unisep.favoriteholidays.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.unisep.favoriteholidays.data.dao.HolidayDao
import br.edu.unisep.favoriteholidays.data.entity.Holiday

@Database(
    entities = arrayOf(Holiday::class),
    exportSchema = false,
    version = 1
)

abstract class HolidayDb : RoomDatabase() {

    abstract fun getHolidayDao(): HolidayDao

    companion object {
        private val DB_NAME = "db_holiday"

        private lateinit var instance: HolidayDb

        fun createInstance(context: Context) {
            instance = Room.databaseBuilder(context, HolidayDb::class.java, DB_NAME).build()
        }

        fun getInstance() = instance
    }
}
