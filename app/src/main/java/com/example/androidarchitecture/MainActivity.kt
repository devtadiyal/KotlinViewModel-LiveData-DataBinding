package com.example.androidarchitecture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecture.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this)
        print("Main On Create")
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        //set viewmodel to binding
        binding.viewModel = viewModel
            //get random no from viewmodel
        val randomNo = viewModel.getRandomData()
        //set random no textview inside onChanged method because value is updating
        randomNo.observe(this, Observer {
            binding.no.setText(randomNo.value)
        })

    }

    override fun onResume() {
        super.onResume()
        println("Main On Resume")
    }
}
