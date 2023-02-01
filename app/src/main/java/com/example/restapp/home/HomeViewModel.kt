package com.example.restapp.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restapp.data.Meals
import com.example.restapp.data.MealsItem
import com.example.restapp.internet.MealsApi
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _meals = MutableLiveData<List<MealsItem>>()
    val meals: LiveData<List<MealsItem>> = _meals

    init{
        getAllMeals()
    }

    private fun getAllMeals() {
        viewModelScope.launch {
            try {
                _meals.value = MealsApi.retrofitService.getMeals().meals
//                Log.d("HomeViewModel", "${_meals.value}")
            } catch (e: Exception) {
                Log.e("HomeViewModel", e.message.orEmpty())
            }
        }
    }
}