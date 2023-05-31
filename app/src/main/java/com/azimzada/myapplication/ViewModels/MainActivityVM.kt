package com.azimzada.myapplication.ViewModels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.azimzada.myapplication.model.JokeDTO
import com.azimzada.myapplication.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

enum class State {
    SUCCESS, ERROR
}
class MainActivityVM : ViewModel() {
    var result = MutableLiveData<JokeDTO?>()
    var state = MutableLiveData<State?>()
    fun getAnswer(context: Context) {
        val call: Call<JokeDTO?>? = RetrofitClient.getRetrofitInstance()?.getApi()?.getAnswer()
        Log.e("Error", call.toString())
        call?.enqueue(object : Callback<JokeDTO?> {
            override fun onResponse(call: Call<JokeDTO?>?, response: Response<JokeDTO?>) {
                Log.e("Error", response.body().toString())

                val result: JokeDTO? = response.body()
                this@MainActivityVM.result.postValue(result)
                if (equals(result?.error)) {
                    this@MainActivityVM.state.postValue(State.SUCCESS)
                } else {
                    this@MainActivityVM.state.postValue(State.ERROR)
                }
            }

            override fun onFailure(call: Call<JokeDTO?>?, t: Throwable?) {
                Log.e("Error", t.toString())
                Log.e("Error", call.toString())

                Toast.makeText(context, "An error has occured", Toast.LENGTH_LONG).show()
            }
        })


    }

    fun observeResult(): LiveData<JokeDTO?> {
        return result
    }

    fun observeState(): LiveData<State?> {
        return state
    }


}