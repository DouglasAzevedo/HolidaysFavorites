package br.edu.unisep.favoriteholidays.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.unisep.favoriteholidays.R
import br.edu.unisep.favoriteholidays.domain.dto.HolidayDto
import kotlinx.android.synthetic.main.item_holidays.view.*

class HolidaysAdapter : RecyclerView.Adapter<HolidaysAdapter.HolidaysViewHolder>() {

    private var holidays: List<HolidayDto> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolidaysViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_holidays, parent, false)
        return HolidaysViewHolder(itemView)
    }

    override fun getItemCount() = holidays.size

    override fun onBindViewHolder(holder: HolidaysViewHolder, position: Int) {
        val holiday = holidays[position]
        holder.itemView.textViewDate.text = holiday.date
        holder.itemView.textViewCountryCode.text = holiday.countryCode
        holder.itemView.textViewHolidayName.text = holiday.name
    }

    fun setHolidays(holidays: List<HolidayDto>) {
        this.holidays = holidays
        notifyDataSetChanged()
    }

    class HolidaysViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}