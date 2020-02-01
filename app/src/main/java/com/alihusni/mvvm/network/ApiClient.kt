package com.alihusni.mvvm.network

import com.alihusni.mvvm.BuildConfig.BASE_URL_MOVIE
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    fun getInterceptor():OkHttpClient{
        val httpLoggingInterceptor = HttpLoggingInterceptor()

        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }
    fun getNetwork():Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL_MOVIE)
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun api(): ApiService{
        return getNetwork().create(ApiService::class.java)
    }
}