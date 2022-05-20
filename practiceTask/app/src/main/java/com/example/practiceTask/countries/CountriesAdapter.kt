package com.example.practiceTask.countries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceTask.api.Countries
import com.example.practiceTask.databinding.FragmentCountryBinding

class CountriesAdapter(private val listener: OnItemClickListener): RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {

    inner class CountriesViewHolder(val binding: FragmentCountryBinding): RecyclerView.ViewHolder(binding.root) {

        init {
            binding.apply {
                root.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        val country = countries[position]
                        listener.onItemClick(country.Slug)
                    }
                }
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(countrySlug: String)
    }

    private val diffCallback = object : DiffUtil.ItemCallback<Countries>() {
        override fun areItemsTheSame(oldItem: Countries, newItem: Countries) =
            oldItem.ISO2 == newItem.ISO2


        override fun areContentsTheSame(oldItem: Countries, newItem: Countries) =
            oldItem == newItem
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var countries: List<Countries>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        return CountriesViewHolder(FragmentCountryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        val currentCountry = countries[position]

        holder.binding.apply {
            staticTextViewCountry.text = "Country: "
            staticTextViewSlug.text = "Slug: "
            staticTextViewIso.text = "ISO2: "
            textViewCountry.text = currentCountry.Country
            textViewIso.text = currentCountry.ISO2
            textViewSlug.text = currentCountry.Slug
        }
    }

    override fun getItemCount() = countries.size

}