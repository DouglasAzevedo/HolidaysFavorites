package br.edu.unisep.favoriteholidays.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import br.edu.unisep.favoriteholidays.R
import br.edu.unisep.favoriteholidays.domain.base.ApiResult
import br.edu.unisep.favoriteholidays.domain.dto.HolidayDto
import kotlinx.android.synthetic.main.item_holidays.*
import java.text.NumberFormat
import java.util.*

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.holidays.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is ApiResult.Success -> onHolidaysResult(result.result)
            }
        })

        setupFavorite()

        getHolidays()

    }

    private fun setupFavorite() {
        //
    }

    private fun getHolidays() {
        homeViewModel.getHolidays()
    }


    private fun onHolidaysResult(holidays: HolidayDto) {
        val formatter = NumberFormat.getInstance(Locale("pt","BR"))

        textViewDate.text = formatter.format(holidays.date)
        textViewHolidayName.text = formatter.format(holidays.name)
        textViewCountryCode.text = formatter.format(holidays.countryCode)
    }

}
