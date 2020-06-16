package br.edu.unisep.favoriteholidays.domain.repository

import br.edu.unisep.favoriteholidays.data.service.factory.HolidayServiceFactory
import br.edu.unisep.favoriteholidays.domain.base.ApiResult
import br.edu.unisep.favoriteholidays.domain.dto.HolidayDto
import java.lang.Exception

class HolidayRepository {

    private val HolidayService = HolidayServiceFactory.getHolidayService()

    suspend fun getHolidays(countryCode: String, year: String): ApiResult<HolidayDto> {
        return try {
            val response = HolidayService.getHolidays(countryCode, year)
            val holidayResponse = response.first()

            ApiResult.Success(
                HolidayDto(
                    holidayResponse.date,
                    holidayResponse.name,
                    holidayResponse.countryCode
                )
            )
        } catch (e: Exception) {
            ApiResult.Error()
        }
    }

}