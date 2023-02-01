package com.example.restapp.internet

import okhttp3.logging.HttpLoggingInterceptor

class Interceptor {
    val loggingInterceptor = HttpLoggingInterceptor().also {
        it.level = HttpLoggingInterceptor.Level.BODY
    }
}