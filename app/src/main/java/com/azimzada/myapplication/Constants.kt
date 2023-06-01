package com.azimzada.myapplication

import com.azimzada.myapplication.api.Api
import com.azimzada.myapplication.network.RetrofitClient

class Constants {
    companion object{
        val BASE_URL = "https://v2.jokeapi.dev/joke/"

        fun getApi(): Api {
            return RetrofitClient.getClient(BASE_URL).create(Api::class.java)
        }
    }
}