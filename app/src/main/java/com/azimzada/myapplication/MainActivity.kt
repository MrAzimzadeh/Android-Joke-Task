package com.azimzada.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.azimzada.myapplication.ViewModels.MainActivityViewModel
import com.azimzada.myapplication.ViewModels.State
import com.azimzada.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var spinner: ProgressBar
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        spinner = findViewById(R.id.progressBar)
        spinner.visibility = View.VISIBLE
        binding.button.setOnClickListener()
        {
            viewModel.getJokes(this)

            viewModel.jokesLiveData.observe(this) {
                spinner.visibility = View.GONE
                binding.jokesTextView.text = viewModel.jokesLiveData.value?.setup
            }
        }
    }

}