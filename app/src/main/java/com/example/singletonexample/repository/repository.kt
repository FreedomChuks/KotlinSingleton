package com.example.singletonexample.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.singletonexample.api.RetrofitBuilder
import com.example.singletonexample.models.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException


/**
 * getUser is a type of livedata that returns live data
 * the onactive is all called when the live data is active
 * **/
object repository{

    fun getUser(userid:String): LiveData<User>{

        return object :LiveData<User>() {
            override fun onActive() {
                CoroutineScope(IO).launch {
                    try {
                        val response=RetrofitBuilder.apiService.getUser(userid)
                        if (response.isSuccessful){
                            withContext(Main){
                                value=response.body()
                            }
                            return@launch
                        }
                        Log.d("Debug error","respones code is ${response.code()} ")
                    }catch (e:Exception){
                        Log.d("Debug error","an error occured ${e.localizedMessage} ")
                    }catch (https:HttpException){
                        Log.d("Https: error","an error occured ${https.message()}")
                    }


                }
            }
        }
    }


}