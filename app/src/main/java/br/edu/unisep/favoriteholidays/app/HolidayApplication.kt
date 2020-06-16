package br.edu.unisep.favoriteholidays.app

import android.app.Application
import br.edu.unisep.favoriteholidays.data.db.HolidayDb

class HolidayApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        HolidayDb.createInstance(applicationContext)
    }
}