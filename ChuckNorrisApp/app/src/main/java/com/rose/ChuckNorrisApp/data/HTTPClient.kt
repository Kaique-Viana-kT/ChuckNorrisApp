package com.rose.ChuckNorrisApp.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HTTPClient {
    private const val BASE_URL = "https://atway.tiagoaguiar.co/fenix/jokerapp/"
    const val API_KEY = "ce619eb9-7d79-4139-afde-166b1c3d23ee"

    private fun httpClient() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    fun retrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient())
        .build()
}