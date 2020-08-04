package com.example.androidarchitecture

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel : ViewModel() {
    private var randomNumber = MutableLiveData<String>()

    fun createRandomNumber() {
        randomNumber?.value = " Number is : ${(0..10).random()}"
        println("Number is : ${(0..10).random()}")
    }

    fun getRandomData(): MutableLiveData<String> {
        if (randomNumber == null) {
            randomNumber = MutableLiveData()
            createRandomNumber()
        }
        return randomNumber
    }


    override fun onCleared() {
        super.onCleared()
        println("on Cleared run")
    }
}