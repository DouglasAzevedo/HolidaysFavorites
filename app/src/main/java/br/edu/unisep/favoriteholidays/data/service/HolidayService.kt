package br.edu.unisep.favoriteholidays.data.service

import br.edu.unisep.favoriteholidays.data.remote.HolidayResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface HolidayService {

    @GET("{Year}/{CountryCode}")
    suspend fun getHolidays(
        @Path("Year") year: String,
        @Path("CountryCode") countryCode: String,
        @Header(HEADER_RAPID_API_HOST) host: String = API_HOST,
        @Header(HEADER_RAPID_API_KEY) apiKey: String = API_KEY
    ): List<HolidayResponse>

}
