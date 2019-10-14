package com.example.singletonexample.api

import com.example.singletonexample.models.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/** suspend function was used here because we are using coroutines to make the call on a seperate thread
 * retrofit 2.6.0 added coroutines natively so that can be done with ease
 * one of the benefits of the retrofit version 2.6.0 is the fact that we can now return back the object in a
 * response wrapper i.e Respnse<UserObject> it helps us eliminate the use of the call object reponse and failed
 *
 * **/
interface ApiServices {
    @GET("placeholder/user/{userid}")
    suspend fun getUser(@Path("userid")userId:String):Response<User>

}