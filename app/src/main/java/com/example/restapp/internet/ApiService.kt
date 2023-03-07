package com.example.restapp.internet

import android.util.Log
import com.example.restapp.BuildConfig
import com.example.restapp.data.Meals
import com.example.restapp.data.MealsCategory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .client(OkHttpClient.Builder().addInterceptor(Interceptor().loggingInterceptor).build())
    .build()

interface MealsApiService {
    @GET("search.php?s")
    suspend fun getMeals(): Meals

    @GET("search.php")
    suspend fun getMealsByLetter(@Query("f") letter: String): Meals

    @GET("list.php?c=list")
    suspend fun getMealsCategory(): MealsCategory
}

object MealsApi {
    val retrofitService: MealsApiService by lazy {
        retrofit.create(MealsApiService::class.java)
    }
}