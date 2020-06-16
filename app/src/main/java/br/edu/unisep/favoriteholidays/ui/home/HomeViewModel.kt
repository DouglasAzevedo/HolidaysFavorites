package br.edu.unisep.favoriteholidays.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.favoriteholidays.domain.base.ApiResult
import br.edu.unisep.favoriteholidays.domain.dto.HolidayDto
import br.edu.unisep.favoriteholidays.domain.repository.HolidayRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = HolidayRepository()

    val holidays = MutableLiveData<ApiResult<HolidayDto>>()

    fun getHolidays(countryCode: String, year: String) {
        viewModelScope.launch {
            val result = repository.getHolidays(
                countryCode, year
            )
            holidays.postValue(result)
        }
    }
}