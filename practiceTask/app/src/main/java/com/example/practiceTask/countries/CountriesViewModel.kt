package com.example.practiceTask.countries

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practiceTask.api.ApiRepository
import com.example.practiceTask.api.Countries
import kotlinx.coroutines.launch

class CountriesViewModel @ViewModelInject constructor(
    private val repository: ApiRepository
): ViewModel() {

    private val _response = MutableLiveData<List<Countries>>()
    val responseCountries : LiveData<List<Countries>>
        get() = _response

    init {
        getCountries()
    }

    private fun getCountries() = viewModelScope.launch {
        repository.getCountries().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("RetroErr", response.code().toString())
            }
        }
    }

}