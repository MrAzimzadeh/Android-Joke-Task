package com.azimzada.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.azimzada.myapplication.ViewModels.MainActivityVM
import com.azimzada.myapplication.ViewModels.State
import com.azimzada.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainActivityVM::class.java]

        binding.button.setOnClickListener {
            reset()
            viewModel.getAnswer(this)
        }

        viewModel.observeState().observe(this, Observer { state ->
            when (state) {
                State.SUCCESS -> {
                    binding.JokeTV.setText(viewModel.result.value?.joke)
                    binding.typeTV.setText(viewModel.result.value?.category)
                    binding.textView3.setText(viewModel.result.value?.delivery)
                }
                State.ERROR -> {
                    binding.JokeTV.setText("You Lost")
                    binding.typeTV.visibility = View.GONE
                    binding.textView3.visibility = View.GONE
                    Log.e("error" , state.toString())
                }

                else -> {}
            }
        })


    }

    fun reset() {
        binding.JokeTV.setText("")
    }
}