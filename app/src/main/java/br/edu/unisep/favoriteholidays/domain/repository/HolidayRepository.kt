package br.edu.unisep.favoriteholidays.domain.repository

import br.edu.unisep.favoriteholidays.data.db.HolidayDb
import br.edu.unisep.favoriteholidays.data.entity.Holiday
import br.edu.unisep.favoriteholidays.data.service.factory.HolidayServiceFactory
import br.edu.unisep.favoriteholidays.domain.base.ApiResult
import br.edu.unisep.favoriteholidays.domain.dto.HolidayDto
import java.lang.Exception

class HolidayRepository {

    private val HolidayService = HolidayServiceFactory.getHolidayService()

    private val holidayDao = HolidayDb.getInstance().getHolidayDao()

    suspend fun getHolidays(year: String, countryCode: String): ApiResult<List<HolidayDto>> {
        return try {
            val response = HolidayService.getHolidays(year, countryCode)

            ApiResult.Success(response.map { holiday ->
                HolidayDto(holiday.date, holiday.name, holiday.countryCode)
            })

        } catch (e: Exception) {
            ApiResult.Error()
        }
    }

    suspend fun findAll(): List<HolidayDto> {
        val result = holidayDao.findAll()
        return result.map { i ->
            HolidayDto(i.date, i.name, i.countryCode)
        }
    }

    suspend fun save(newHoliday: HolidayDto) {
        val holiday = Holiday(newHoliday.date, newHoliday.name, newHoliday.countryCode)
        holidayDao.save(holiday)
    }

    suspend fun deleteByName(holidayDelete : HolidayDto) {
        holidayDao.deleteByName(holidayDelete.name)
    }

}