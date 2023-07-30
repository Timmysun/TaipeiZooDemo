package com.demo.tpzoo.model

import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//https://data.taipei/api/v1/dataset/5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a?scope=resourceAcquire

const val API_BASE_URL = "https://data.taipei/"

object DataAgent {

    interface OpenDataApi {
        @GET("api/v1/dataset/5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a?scope=resourceAquire")
        suspend fun zooIntroduction(): Response<IntroductionResult>
    }

    val openDataApi: OpenDataApi by lazy {
        Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
            .create(OpenDataApi::class.java)
    }
}