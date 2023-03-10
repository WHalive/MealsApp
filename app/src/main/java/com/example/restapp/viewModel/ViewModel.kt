package com.example.restapp.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restapp.data.CategoryItem
import com.example.restapp.data.CategoryMealsItem
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

    private val _mealsCategory = MutableLiveData<List<CategoryItem>>()
    val mealsCategory: LiveData<List<CategoryItem>> = _mealsCategory

    private val _categoryMeals = MutableLiveData<List<CategoryMealsItem>>()
    val categoryMeals: LiveData<List<CategoryMealsItem>> = _categoryMeals

    init {
        getAllMeals()
    }

    private fun getAllMeals() {
        viewModelScope.launch {
            try {
                _meals.value = MealsApi.retrofitService.getMeals().meals
                _mealsCategory.value = MealsApi.retrofitService.getMealsCategory().meals

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

    fun categoryMealsByWords(words: String) {
        viewModelScope.launch {
            try {
                _categoryMeals.value = MealsApi.retrofitService.getCategoryMealsByWords(words).meals

            } catch (e: Exception) {
                Log.e("viewModel", e.message.orEmpty())
            }
        }
    }
}

