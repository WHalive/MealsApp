package com.example.restapp.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Meals(@SerializedName("meals") val meals: List<MealsItem>): Parcelable

@Parcelize
data class MealsItem(
    @SerializedName("idMeal") var mealId: String,
    @SerializedName("strMeal") var name: String,
    @SerializedName("strArea") val area: String,
    @SerializedName("strInstructions") val instruction: String,
    @SerializedName("strMealThumb") val image: String,
    @SerializedName("strCategory") val type: String,
    @SerializedName("strYoutube") val video: String,
    @SerializedName("strIngredient1") val ing1: String = "",
    @SerializedName("strIngredient2") val ing2: String = "",
    @SerializedName("strIngredient3") val ing3: String = "",
    @SerializedName("strIngredient4") val ing4: String = "",
    @SerializedName("strIngredient5") val ing5: String = "",
    @SerializedName("strIngredient6") val ing6: String = "",
    @SerializedName("strIngredient7") val ing7: String = "",
    @SerializedName("strIngredient8") val ing8: String = "",
    @SerializedName("strIngredient9") val ing9: String = "",
    @SerializedName("strIngredient10") val ing10: String = "",
    @SerializedName("strIngredient11") val ing11: String = "",
    @SerializedName("strIngredient12") val ing12: String = "",
    @SerializedName("strIngredient13") val ing13: String = "",
    @SerializedName("strIngredient14") val ing14: String = "",
    @SerializedName("strIngredient15") val ing15: String = "",
    @SerializedName("strIngredient16") val ing16: String = "",
    @SerializedName("strIngredient17") val ing17: String = "",
    @SerializedName("strIngredient18") val ing18: String = "",
    @SerializedName("strMeasure2") val m2: String = "",
    @SerializedName("strMeasure3") val m3: String = "",
    @SerializedName("strMeasure4") val m4: String = "",
    @SerializedName("strMeasure5") val m5: String = "",
    @SerializedName("strMeasure6") val m6: String = "",
    @SerializedName("strMeasure7") val m7: String = "",
    @SerializedName("strMeasure8") val m8: String = "",
    @SerializedName("strMeasure9") val m9: String = "",
    @SerializedName("strMeasure10") val m10: String = "",
    @SerializedName("strMeasure11") val m11: String = "",
    @SerializedName("strMeasure12") val m12: String = "",
    @SerializedName("strMeasure13") val m13: String = "",
    @SerializedName("strMeasure14") val m14: String = "",
    @SerializedName("strMeasure15") val m15: String = "",
    @SerializedName("strMeasure16") val m16: String = "",
    @SerializedName("strMeasure17") val m17: String = "",
    @SerializedName("strMeasure18") val m18: String = "",
    @SerializedName("strMeasure1") val m1: String = ""
): Parcelable
