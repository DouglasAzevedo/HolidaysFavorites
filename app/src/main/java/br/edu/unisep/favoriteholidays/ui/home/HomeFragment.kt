package br.edu.unisep.favoriteholidays.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.unisep.favoriteholidays.R
import br.edu.unisep.favoriteholidays.domain.base.ApiResult
import br.edu.unisep.favoriteholidays.domain.dto.HolidayDto
import br.edu.unisep.favoriteholidays.ui.home.adapter.HolidaysAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.item_holidays.*
import java.text.NumberFormat
import java.util.*

class HomeFragment : Fragment() {

    private var adapter = HolidaysAdapter()

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

        buttonSearch.setOnClickListener { this.getHolidays() }

        homeViewModel.holidays.observe(viewLifecycleOwner, Observer { result ->
            if (result is ApiResult.Success) {
                adapter.setHolidays(result.result)
            } else {
                onTotalsError()
            }
        })

    }

    private fun setupList() {
        listHolidays.adapter = adapter

        listHolidays.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.VERTICAL, false
        )
        listHolidays.addItemDecoration(
            DividerItemDecoration(
                context, DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun setupFavorite() {
        //
    }

    private fun getHolidays() {
        progressBarTotals.visibility = View.VISIBLE
        refreshHome.isRefreshing = false

        homeViewModel.getHolidays(editTextCountrie.text.toString(), editTextYear.text.toString())
        setupList()
    }

    private fun onTotalsError() {
        progressBarTotals.visibility = View.INVISIBLE
    }

}
