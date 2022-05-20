package com.example.practiceTask.countryDetail

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.practiceTask.api.ApiRepository
import com.example.practiceTask.api.Country
import kotlinx.coroutines.launch

class CountryDetailViewModel @ViewModelInject constructor(
    private val repository: ApiRepository,
    @Assisted private val state: SavedStateHandle
): ViewModel() {

    private val _response = MutableLiveData<List<Country>>()
    val responseCountryDetail : LiveData<List<Country>>
        get() = _response

    val countrySlug = state.get<String>("countrySlug")

    init {
        getCountry()
    }

    private fun getCountry() = viewModelScope.launch {
        if (countrySlug != null) {
            repository.getCountry(countrySlug).let { response ->
                if (response.isSuccessful) {
                    _response.postValue(response.body())
                } else {
                    Log.d("RetroErr", response.code().toString())
                }
            }
        }
    }

}