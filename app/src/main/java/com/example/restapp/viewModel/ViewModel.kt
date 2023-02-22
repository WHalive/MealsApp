package com.example.restapp.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restapp.data.MealsItem
import com.example.restapp.internet.MealsApi
import com.example.restapp.list.ListFragment
import com.example.restapp.word.WordFragment
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {

    private val _meals = MutableLiveData<List<MealsItem>>()
    val meals: LiveData<List<MealsItem>> = _meals

    private val _mealsName = MutableLiveData<List<MealsItem>>()
    val mealsName: LiveData<List<MealsItem>> = _mealsName

    init {
        getAllMeals()
    }

    private fun getAllMeals() {
        viewModelScope.launch {
            try {
                _meals.value = MealsApi.retrofitService.getMeals().meals

            } catch (e: Exception) {
                Log.e("ViewModel", e.message.orEmpty())
            }
        }
    }

    fun mealsNameByLetter(letter: String) {
        viewModelScope.launch {
            try {
                _mealsName.value = MealsApi.retrofitService.getMealsByLetter(letter).meals

            } catch (e: Exception) {
                Log.e("ViewModel", e.message.orEmpty())
            }
        }
    }
}

