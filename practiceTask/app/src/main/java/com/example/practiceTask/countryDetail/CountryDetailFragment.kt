package com.example.practiceTask.countryDetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.practiceTask.R
import com.example.practiceTask.databinding.FragmentCountryDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountryDetailFragment: Fragment(R.layout.fragment_country_detail) {

    private val viewModel: CountryDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentCountryDetailBinding.bind(view)

        viewModel.responseCountryDetail.observe(viewLifecycleOwner) { country ->
            binding.apply {

                staticTextViewCountryId.text = "ID: "
                staticTextViewCountryName.text = "Name: "
                staticTextViewCountryCode.text = "Code: "
                staticTextViewCountryProvince.text = "Province: "
                staticTextViewCountryCity.text = "City: "
                staticTextViewCountryCityCode.text = "City Code: "
                staticTextViewCountryLat.text = "Lat: "
                staticTextViewCountryLon.text = "Lon: "
                staticTextViewCountryConfirmed.text = "Confirmed: "
                staticTextViewCountryDeaths.text = "Deaths: "
                staticTextViewCountryRecovered.text = "Recovered: "
                staticTextViewCountryActive.text = "Active: "
                staticTextViewCountryDate.text = "Date: "

                if (country.isEmpty()) {
                    textViewCountryId.text = "Not Found"
                    textViewCountryName.text = "Not Found"
                    textViewCountryCode.text = "Not Found"
                    textViewCountryProvince.text = "Not Found"
                    textViewCountryCity.text = "Not Found"
                    textViewCountryCityCode.text = "Not Found"
                    textViewCountryLat.text = "Not Found"
                    textViewCountryLon.text = "Not Found"
                    textViewCountryConfirmed.text = "Not Found"
                    textViewCountryDeaths.text = "Not Found"
                    textViewCountryRecovered.text = "Not Found"
                    textViewCountryActive.text = "Not Found"
                    textViewCountryDate.text = "Not Found"
                } else {
                    textViewCountryId.text = country.last().ID
                    textViewCountryName.text = country.last().Country
                    textViewCountryCode.text = country.last().CountryCode
                    textViewCountryProvince.text = country.last().Province
                    textViewCountryCity.text = country.last().City
                    textViewCountryCityCode.text = country.last().CityCode
                    textViewCountryLat.text = country.last().Lat
                    textViewCountryLon.text = country.last().Lon
                    textViewCountryConfirmed.text = country.last().Confirmed
                    textViewCountryDeaths.text = country.last().Deaths.toString()
                    textViewCountryRecovered.text = country.last().Recovered.toString()
                    textViewCountryActive.text = country.last().Active.toString()
                    textViewCountryDate.text = country.last().Date
                }
            }
        }
    }
}