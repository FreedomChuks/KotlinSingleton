package com.example.singletonexample.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/** This class is for seting up retrofit creating a builder
 * the use of an object here instead of a class is to create a singleton for retrofit to avoid multiple instace
 * creation
 * Note: an object marks this class as a singleton
 *
 * Note lazy makes the field null only when it called that it provides one instance of the field
 * we added a gson converter that convert json object to kotlin/java object
 *
 * no call adapter was added because retrofit added coroutines nativly
 *
 *
 * **/
object RetrofitBuilder {

const val BASE_URL="https://open-api.xyz/"

    /**Singleton retrofit builder**/
    val retofitBuilder : Retrofit.Builder by lazy {
       Retrofit.Builder()
           .baseUrl(BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
    }

    /** Singleton Api service **/
    val apiService:ApiServices by lazy {
         retofitBuilder.build().create(ApiServices::class.java)
    }

}