package br.edu.unisep.favoriteholidays.data.service.factory

import br.edu.unisep.favoriteholidays.data.service.HolidayService
import br.edu.unisep.favoriteholidays.data.service.URL_BASE
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object HolidayServiceFactory {

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    fun getHolidayService() = retrofit.create(HolidayService::class.java)
}