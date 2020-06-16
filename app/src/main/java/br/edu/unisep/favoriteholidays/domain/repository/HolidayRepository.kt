package br.edu.unisep.favoriteholidays.domain.repository

import br.edu.unisep.favoriteholidays.data.service.factory.HolidayServiceFactory
import br.edu.unisep.favoriteholidays.domain.base.ApiResult
import br.edu.unisep.favoriteholidays.domain.dto.HolidayDto
import java.lang.Exception

class HolidayRepository {

    private val HolidayService = HolidayServiceFactory.getHolidayService()

    suspend fun getHolidays(countryCode: String, year: String): ApiResult<List<HolidayDto>> {
        return try {
            val response = HolidayService.getHolidays(countryCode, year)

            ApiResult.Success(response.map { holiday ->
                HolidayDto(holiday.date, holiday.name, holiday.countryCode)
            })
        } catch (e: Exception) {
            ApiResult.Error()
        }
    }

}