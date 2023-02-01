package com.example.restapp.data

import com.google.gson.annotations.SerializedName

data class Meals(@SerializedName("meals") val meals: List<MealsItem>)

data class MealsItem(
    @SerializedName("strMeal") val name: String,
    @SerializedName("strArea") val area: String,
    @SerializedName("strInstructions") val instruction: String,
    @SerializedName("strMealThumb") val image: String,
    @SerializedName("strTags") val type: String,
    @SerializedName("strYoutube") val video: String
    )

