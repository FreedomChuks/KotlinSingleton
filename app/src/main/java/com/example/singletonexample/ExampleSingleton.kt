package com.example.singletonexample

import com.example.singletonexample.models.User

//Todo an object is kotlin signleton
//Todo only one instace of this object would be created and wont ceate any other instace
object ExampleSingleton{

//Todo lazy inialization only inialize that feild once and only when it called

    val singletonUser: User by lazy {
        User(
            "freedom.chuks7@gmail.com",
            "freedom",
            "images.png"
        )
    }

}