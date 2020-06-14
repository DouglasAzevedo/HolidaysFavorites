package br.edu.unisep.favoriteholidays.data.service

import br.edu.unisep.favoriteholidays.data.remote.HolidayResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface HolidayService {

    @GET(SERVICE_GET_PUBLIC_HOLIDAYS)
    suspend fun getHolidays(
        @Query("countrycode") countryCode: String,
        year: String,
        @Header(HEADER_RAPID_API_HOST) host: String = API_HOST,
        @Header(HEADER_RAPID_API_KEY) apiKey: String = API_KEY
    ): List<HolidayResponse>

}
