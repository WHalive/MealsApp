package com.example.restapp.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MealsCategory(@SerializedName("meals") val meals: List<CategoryItem>) : Parcelable

@Parcelize
data class CategoryItem(@SerializedName("strCategory") val category: String? = null) : Parcelable

@Parcelize
data class Meals(@SerializedName("meals") val meals: List<MealsItem>) : Parcelable

@Parcelize
data class MealsItem(
    @SerializedName("idMeal") var mealId: String? = null,
    @SerializedName("strMeal") var name: String? = null,
    @SerializedName("strArea") val area: String? = null,
    @SerializedName("strInstructions") val instruction: String? = null,
    @SerializedName("strMealThumb") val image: String? = null,
    @SerializedName("strCategory") val type: String? = null,
    @SerializedName("strYoutube") val video: String? = null,
    @SerializedName("strIngredient1") val ing1: String? = null,
    @SerializedName("strIngredient2") val ing2: String? = null,
    @SerializedName("strIngredient3") val ing3: String? = null,
    @SerializedName("strIngredient4") val ing4: String? = null,
    @SerializedName("strIngredient5") val ing5: String? = null,
    @SerializedName("strIngredient6") val ing6: String? = null,
    @SerializedName("strIngredient7") val ing7: String? = null,
    @SerializedName("strIngredient8") val ing8: String? = null,
    @SerializedName("strIngredient9") val ing9: String? = null,
    @SerializedName("strIngredient10") val ing10: String? = null,
    @SerializedName("strIngredient11") val ing11: String? = null,
    @SerializedName("strIngredient12") val ing12: String? = null,
    @SerializedName("strIngredient13") val ing13: String? = null,
    @SerializedName("strIngredient14") val ing14: String? = null,
    @SerializedName("strIngredient15") val ing15: String? = null,
    @SerializedName("strIngredient16") val ing16: String? = null,
    @SerializedName("strIngredient17") val ing17: String? = null,
    @SerializedName("strIngredient18") val ing18: String? = null,
    @SerializedName("strIngredient19") val ing19: String? = null,
    @SerializedName("strIngredient20") val ing20: String? = null,
    @SerializedName("strMeasure1") val m1: String? = null,
    @SerializedName("strMeasure2") val m2: String? = null,
    @SerializedName("strMeasure3") val m3: String? = null,
    @SerializedName("strMeasure4") val m4: String? = null,
    @SerializedName("strMeasure5") val m5: String? = null,
    @SerializedName("strMeasure6") val m6: String? = null,
    @SerializedName("strMeasure7") val m7: String? = null,
    @SerializedName("strMeasure8") val m8: String? = null,
    @SerializedName("strMeasure9") val m9: String? = null,
    @SerializedName("strMeasure10") val m10: String? = null,
    @SerializedName("strMeasure11") val m11: String? = null,
    @SerializedName("strMeasure12") val m12: String? = null,
    @SerializedName("strMeasure13") val m13: String? = null,
    @SerializedName("strMeasure14") val m14: String? = null,
    @SerializedName("strMeasure15") val m15: String? = null,
    @SerializedName("strMeasure16") val m16: String? = null,
    @SerializedName("strMeasure17") val m17: String? = null,
    @SerializedName("strMeasure18") val m18: String? = null,
    @SerializedName("strMeasure19") val m19: String? = null,
    @SerializedName("strMeasure20") val m20: String? = null
) : Parcelable
