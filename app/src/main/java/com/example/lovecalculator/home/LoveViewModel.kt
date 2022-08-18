package com.example.lovecalculator.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.Repository
import com.example.lovecalculator.network.LoveModel

class LoveViewModel : ViewModel() {

    private val repository = Repository()

    fun fillLoveModel(firstName: String,secondName: String): MutableLiveData<LoveModel>{
        return repository.getLoveModel(firstName, secondName)
    }

}