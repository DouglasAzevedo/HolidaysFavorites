package br.edu.unisep.favoriteholidays.ui.favorite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.favoriteholidays.domain.dto.HolidayDto
import br.edu.unisep.favoriteholidays.domain.repository.HolidayRepository
import kotlinx.coroutines.launch

class FavoriteViewModel : ViewModel() {

    private val repository = HolidayRepository()

    val holidays = MutableLiveData<List<HolidayDto>>()

    fun getHoliday() {
        viewModelScope.launch {
            val result = repository.findAll()
            holidays.postValue(result)
        }
    }
}