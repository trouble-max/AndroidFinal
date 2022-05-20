package com.example.practiceTask.countries

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practiceTask.R
import com.example.practiceTask.databinding.FragmentCountriesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountriesFragment: Fragment(R.layout.fragment_countries), CountriesAdapter.OnItemClickListener {

    private val viewModel: CountriesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentCountriesBinding.bind(view)
        val countriesAdapter = CountriesAdapter(this)

        binding.apply {
            recyclerViewCountries.apply {
                adapter = countriesAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            }
        }

        viewModel.responseCountries.observe(viewLifecycleOwner) { countries ->
            countriesAdapter.countries = countries
        }
    }

    override fun onItemClick(countrySlug: String) {
        val action = CountriesFragmentDirections.actionCountriesFragmentToCountryDetailFragment(countrySlug)
        findNavController().navigate(action)
    }

}