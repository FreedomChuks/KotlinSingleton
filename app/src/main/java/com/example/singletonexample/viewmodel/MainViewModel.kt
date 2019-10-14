package com.example.singletonexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.singletonexample.models.User
import com.example.singletonexample.repository.repository

class MainViewModel :ViewModel(){
   private val _userId:MutableLiveData<String> = MutableLiveData()

    //it takes a string and return back an object
    val user:LiveData<User> =Transformations
        .switchMap(_userId){
            repository.getUser(it)
        }

    fun setUserId(userId:String){
        if (_userId.value== userId){
        return
        }
        _userId.value= userId

    }

}