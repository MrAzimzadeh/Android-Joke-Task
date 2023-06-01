package com.azimzada.myapplication.api

import com.azimzada.myapplication.model.Jokes
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("Any")
    fun getJokesData(): Call<Jokes>
}