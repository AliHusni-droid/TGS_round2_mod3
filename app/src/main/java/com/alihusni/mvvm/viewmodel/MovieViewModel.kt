package com.alihusni.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alihusni.mvvm.Model.MovieResponse
import com.alihusni.mvvm.network.ApiClient
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MovieViewModel : ViewModel() {
    private var data = MutableLiveData<MovieResponse>()
    private var status = MutableLiveData<Boolean>()

    init {
        getData()
    }
    private fun getData(){
        status.value = true

        ApiClient().api().movie().enqueue(object: Callback<MovieResponse> {
            fun onFailure(call: Call<MovieResponse>, t:Throwable){
                status.value = true
                data.value = null
            }
            fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>){
                status.value = false

                if (response.isSuccessful){
                    data.value = response.body()
                }
                else{
                    status.value = true
                }
            }
        })
    }
    fun setData():MutableLiveData<MovieResponse>{
        return data
    }
    fun getStatus(): MutableLiveData<Boolean> {
        status.value = false

        return status
    }
}