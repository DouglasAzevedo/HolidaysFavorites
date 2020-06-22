package br.edu.unisep.favoriteholidays.ui.favorite.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.unisep.favoriteholidays.R
import br.edu.unisep.favoriteholidays.domain.dto.HolidayDto
import kotlinx.android.synthetic.main.item_holidays.view.*

class FavoriteAdapter: RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    private var favorites: List<HolidayDto> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_holidays, parent, false)
        return FavoriteAdapter.FavoriteViewHolder(itemView)
    }

    override fun getItemCount() = favorites.size

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val holiday = favorites[position]
        holder.itemView.textViewDate.text = holiday.date
        holder.itemView.textViewCountryCode.text = holiday.countryCode
        holder.itemView.textViewHolidayName.text = holiday.name
        holder.itemView.imageViewFavorite.setOnClickListener {

            notifyDataSetChanged()
        }
    }

    class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}