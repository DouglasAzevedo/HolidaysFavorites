package br.edu.unisep.favoriteholidays.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.favoriteholidays.domain.base.ApiResult
import br.edu.unisep.favoriteholidays.domain.dto.HolidayDto
import br.edu.unisep.favoriteholidays.domain.repository.HolidayRepository
import kotlinx.coroutines.launch

typealias ApiResultHolidays = ApiResult<List<HolidayDto>>

class HomeViewModel : ViewModel() {

    private val repository = HolidayRepository()

    val holidays = MutableLiveData<ApiResultHolidays>()

    fun getHolidays(year: String, countryCode: String) {
        viewModelScope.launch {
            val result = repository.getHolidays(
                year, countryCode
            )
            holidays.postValue(result)
        }
    }
}