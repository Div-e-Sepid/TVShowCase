package com.boozt.tvshowcase.main.overview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.boozt.tvshowcase.domain.Model
import com.boozt.tvshowcase.main.databinding.ItemSeasonBinding

class SeasonsAdapter(
    private val onItemClick: (Model.Season) -> Unit
) : ListAdapter<Model.Season, SeasonsAdapter.SeasonViewHolder>(DiffCallback) {

    object DiffCallback : DiffUtil.ItemCallback<Model.Season>() {

        override fun areItemsTheSame(oldItem: Model.Season, newItem: Model.Season): Boolean =
            oldItem.title == newItem.title

        override fun areContentsTheSame(oldItem: Model.Season, newItem: Model.Season): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonViewHolder {
        val binding = ItemSeasonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = SeasonViewHolder(binding)
        binding.seasonTitleTextView.setOnClickListener {
            onItemClick(getItem(holder.adapterPosition))
        }
        return holder
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: SeasonViewHolder, position: Int) {
        holder.binding.seasonTitleTextView.text = "Season ${getItem(position).title}"
    }

    class SeasonViewHolder(val binding: ItemSeasonBinding) : RecyclerView.ViewHolder(binding.root)
}