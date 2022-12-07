package com.example.weatherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.models.CurrentConditions
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val currentConditions: CurrentConditions,
) : ViewModel() {

    private val _viewState = MutableLiveData<CurrentConditions>()

    val viewState: LiveData<CurrentConditions> = _viewState

    init {
        _viewState.value = currentConditions
    }
}