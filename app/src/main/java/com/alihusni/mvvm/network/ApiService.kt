package com.alihusni.mvvm.network

import com.alihusni.mvvm.BuildConfig.API_INTERFACE
import com.alihusni.mvvm.Model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET(API_INTERFACE)
    fun movie(): Call<MovieResponse>
}