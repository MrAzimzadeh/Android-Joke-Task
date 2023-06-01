package com.azimzada.myapplication.ViewModels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.azimzada.myapplication.Constants
import com.azimzada.myapplication.api.Api
import com.azimzada.myapplication.model.Jokes
import com.azimzada.myapplication.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

enum class State {
    SUCCESS, ERROR
}
class MainActivityViewModel: ViewModel() {
    lateinit var api: Api
    var jokesLiveData = MutableLiveData<Jokes>()

    fun getJokes(context : Context) {
        api = Constants.getApi()
        api.getJokesData().enqueue(object: Callback<Jokes> {
            override fun onResponse(call: Call<Jokes>, response: Response<Jokes>) {
                val data: Jokes? = response.body()
                this@MainActivityViewModel.jokesLiveData.postValue(data)
            }

            override fun onFailure(call: Call<Jokes>, t: Throwable) {
                Toast.makeText(context, "An error has occurred", Toast.LENGTH_LONG).show()
            }

        })

    }
}