package com.azimzada.myapplication.api

import com.azimzada.myapplication.model.JokeDTO
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("joke/Any")
    fun getAnswer(): Call<JokeDTO?>?

}