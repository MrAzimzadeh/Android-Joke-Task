package com.azimzada.myapplication.network

import com.azimzada.myapplication.Constants
import com.azimzada.myapplication.api.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {
    companion object{
        fun getClient(baseUrl : String): Retrofit {
            return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}