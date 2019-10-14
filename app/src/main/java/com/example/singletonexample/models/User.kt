package com.example.singletonexample.models

data class User(
    val email:String,
    val username:String,
    val image:String
) {
    override fun toString(): String {
     return "User(email=$email, username=$username, image=$image)"
    }
}